package com.example.yucalorie.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.yucalorie.R;
import com.example.yucalorie.desktop.desktop1_2;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;

public class CalorieManager extends Service{
	
	public static String ACTION_DESKTOP_CLICK_PLAY="action_desktop_click_play";
	
	public static UserInfo userInfo;//用户信息
	public static int UpdateWidgetMillisecond;//更新桌面组件的毫秒数
	public static int UpdateSQLiteMillisecond;//更新数据库的毫秒数
	public static CalorieSQLite SQLite;//数据库类
	public static List<DesktopInfo> mDesktopInfos;
	private SensorManager mSensorMgr;
	private CalorieListener mCalorieListener;//监听手机水平传感器
	private static boolean mIsPlayCalorieListener;//是否监听手机水平传感器（步幅）
	
	private Thread mUpdateSQLiteThread;//更新数据库的线程
	private Thread mUpdateDesktopThread;//更新桌面数据的线程
	@Override
	public void onCreate() {
		
		SQLInit();//数据库初始化
		UserInit();//用户信息初始化
		RegCalorieListenerInit();//监听水平传感器初始化
		BroadcastReceiverInit();//监听的广播初始化
		ManagerInit();//管理参数初始化
		super.onCreate();
	}
	
	private BroadcastReceiver mBroadcastReceiver=new BroadcastReceiver()
	{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if(intent.getAction().equals(ACTION_DESKTOP_CLICK_PLAY))
			{
				RemoteViews remoteViews= new RemoteViews(context.getPackageName(),R.layout.desktop1_2);
				if(IsRun())
				{
					StopCalc();//停止计算卡路里
					remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_play);
					Log.e("状态改变", "停止");
				}
				else {
					StartCalc();//开始计算卡路里
					remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_stop);
					Log.e("状态改变", "开始");
				}
				AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context); 
		        ComponentName componentName = new ComponentName(context,desktop1_2.class);
				appWidgetManager.updateAppWidget(componentName, remoteViews);
			}
		}
		
	};
	
	//添加桌面程序需要更新的信息
	/*public static void AddDesktop(DesktopInfo desktopInfo)
	{
		AddDesktop(desktopInfo);
	}*/
	public static void AddDesktop(Context c,AppWidgetManager a,RemoteViews r,Class<?> cls)
	{
		if(mDesktopInfos==null)
			CalorieManager.mDesktopInfos=new ArrayList<DesktopInfo>();//初始化桌面程序数组
		DesktopInfo desktopInfo = new DesktopInfo(c, a, r,cls);
		mDesktopInfos.add(desktopInfo);
		
		if(desktopInfo.context!=null)
		{
			RemoteViews remoteViews= new RemoteViews(desktopInfo.context.getPackageName(),R.layout.desktop1_2);
			if(IsRun())
			{
				remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_stop);
			}
			else {
				remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_play);
			}
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(desktopInfo.context); 
	        ComponentName componentName = new ComponentName(desktopInfo.context,desktop1_2.class);
			appWidgetManager.updateAppWidget(componentName, remoteViews);
		}
	}
	//监听的广播初始化
	private void BroadcastReceiverInit()
	{
		//注册广播
  		IntentFilter intentFilter=new IntentFilter();
  		intentFilter.addAction(ACTION_DESKTOP_CLICK_PLAY);
  		registerReceiver(mBroadcastReceiver, intentFilter);
	}
	//管理参数初始化
	private void ManagerInit()
	{
		UpdateSQLiteMillisecond=60000;//数据库更新间隔毫秒数
		UpdateWidgetMillisecond=10000;//桌面组件更新间隔毫秒数
		if(mDesktopInfos==null)
			CalorieManager.mDesktopInfos=new ArrayList<DesktopInfo>();//初始化桌面程序数组
		
		mUpdateSQLiteThread=new Thread(mUpdateSQLRunnable);
		mUpdateSQLiteThread.start();
		mUpdateDesktopThread=new Thread(mUpdateDesktopRunnable);
		mUpdateDesktopThread.start();
	}
	//用户信息初始化
	private void UserInit()
	{
		if(userInfo==null)
			userInfo = new UserInfo();
	}
	//卡路里步幅监听器初始化
	private void RegCalorieListenerInit()
	{
		mCalorieListener=new CalorieListener(userInfo.calorieInfo);
		mSensorMgr = (SensorManager)this.getSystemService(android.content.Context.SENSOR_SERVICE );
		this.StartCalc();
	}
	//数据库初始化
	private void SQLInit()
	{
		SQLite=new CalorieSQLite(this, "yucalorie.db", null, 1);
		CalorieManager.userInfo=SQLite.GetUserInfo();
		mIsPlayCalorieListener=SQLite.GetCalorieRunState();//是否开始记卡路里
	}
	
	//卡路里计算是否运行
	public static boolean IsRun()
	{
		return mIsPlayCalorieListener;
	}
	
	//停止计算卡路里
	@SuppressWarnings("deprecation")
	public void StopCalc()
	{
		mIsPlayCalorieListener=false;
		if(mSensorMgr!=null && mCalorieListener!=null)
		{
			Sensor sensor = mSensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			mSensorMgr.unregisterListener(mCalorieListener,sensor);
		}
		SQLite.SetCalorieRunState(false);
		/*try {
			mUpdateSQLiteThread.stop();
			mUpdateDesktopThread.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
	//开始计算卡路里
	public void StartCalc()
	{
		mIsPlayCalorieListener=true;
		if(mSensorMgr!=null && mCalorieListener!=null)
		{
			Sensor sensor = mSensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			mSensorMgr.registerListener(mCalorieListener, sensor, SensorManager.SENSOR_DELAY_GAME);
		}
		SQLite.SetCalorieRunState(true);
	}
	
	private	Handler mUpdateSQLHandler = new Handler() {  
        public void handleMessage(Message msg) {   
             switch (msg.what) {   
                  case 1:   
                	  userInfo.calorieInfo.TodayInit();//初始化calorinfo控件
                      break;   
             }   
             super.handleMessage(msg);   
        }   
    }; 
	//更新数据到数据库
	private  Runnable  mUpdateSQLRunnable = new Runnable() {   
       public void run() {
            while (true) { 
            	SQLite.UpdateFrequency(CalorieManager.userInfo);//更新步数和卡路里
            	//Log.e("卡路里",userInfo.calorieInfo.getFrequency()+"");
            	if(!userInfo.calorieInfo.IsToday())//如果calorieinfo里记录的日期和当前日期不同，则初始化calorieinfo
            	{
            		Message message = new Message();   
                    message.what = 1;
                    mUpdateSQLHandler.sendMessage(message);  
            	}
            	try {   
                    Thread.sleep(CalorieManager.UpdateSQLiteMillisecond);//SQL更新间隔毫秒数 
               } catch (InterruptedException e) {   
                    Thread.currentThread().interrupt();   
               }  
            }   
       }   
	};
	
	//更新桌面组件数据
	private void UpdateDesktops()
	{
		for (DesktopInfo desktopInfo : mDesktopInfos) {
			desktopInfo.remoteViews.setTextViewText(com.example.yucalorie.R.id.desktop_frequency, 
					String.format("%1$,04d",userInfo.calorieInfo.getFrequency()));
			desktopInfo.remoteViews.setTextViewText(com.example.yucalorie.R.id.desktop_calorie, 
					String.format("%1$,04d",userInfo.calorieInfo.getCalorie()));
			ComponentName componentName=new ComponentName(desktopInfo.context,desktopInfo.Class);
			desktopInfo.appWidgetManager.updateAppWidget(componentName, desktopInfo.remoteViews);
		}
	}
	
	private	Handler mUpdateDesktopHandler = new Handler() {  
        public void handleMessage(Message msg) {   
             switch (msg.what) {   
                  case 1:   
                	  UpdateDesktops();  
                      break;   
             }   
             super.handleMessage(msg);   
        }   
    }; 
	private  Runnable  mUpdateDesktopRunnable = new Runnable() {   
       public void run() {
            while (true) { 
            	Message message = new Message();   
                message.what = 1;
                mUpdateDesktopHandler.sendMessage(message);   
            	try {   
                    Thread.sleep(CalorieManager.UpdateWidgetMillisecond);//桌面组件更新间隔毫秒数 
               } catch (InterruptedException e) {   
                    Thread.currentThread().interrupt();   
               }  
            }   
       }   
	};
		
		
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
