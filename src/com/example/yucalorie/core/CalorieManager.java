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
	
	public static UserInfo userInfo;//�û���Ϣ
	public static int UpdateWidgetMillisecond;//������������ĺ�����
	public static int UpdateSQLiteMillisecond;//�������ݿ�ĺ�����
	public static CalorieSQLite SQLite;//���ݿ���
	public static List<DesktopInfo> mDesktopInfos;
	private SensorManager mSensorMgr;
	private CalorieListener mCalorieListener;//�����ֻ�ˮƽ������
	private static boolean mIsPlayCalorieListener;//�Ƿ�����ֻ�ˮƽ��������������
	
	private Thread mUpdateSQLiteThread;//�������ݿ���߳�
	private Thread mUpdateDesktopThread;//�����������ݵ��߳�
	@Override
	public void onCreate() {
		
		SQLInit();//���ݿ��ʼ��
		UserInit();//�û���Ϣ��ʼ��
		RegCalorieListenerInit();//����ˮƽ��������ʼ��
		BroadcastReceiverInit();//�����Ĺ㲥��ʼ��
		ManagerInit();//���������ʼ��
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
					StopCalc();//ֹͣ���㿨·��
					remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_play);
					Log.e("״̬�ı�", "ֹͣ");
				}
				else {
					StartCalc();//��ʼ���㿨·��
					remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_stop);
					Log.e("״̬�ı�", "��ʼ");
				}
				AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context); 
		        ComponentName componentName = new ComponentName(context,desktop1_2.class);
				appWidgetManager.updateAppWidget(componentName, remoteViews);
			}
		}
		
	};
	
	//������������Ҫ���µ���Ϣ
	/*public static void AddDesktop(DesktopInfo desktopInfo)
	{
		AddDesktop(desktopInfo);
	}*/
	public static void AddDesktop(Context c,AppWidgetManager a,RemoteViews r,Class<?> cls)
	{
		if(mDesktopInfos==null)
			CalorieManager.mDesktopInfos=new ArrayList<DesktopInfo>();//��ʼ�������������
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
	//�����Ĺ㲥��ʼ��
	private void BroadcastReceiverInit()
	{
		//ע��㲥
  		IntentFilter intentFilter=new IntentFilter();
  		intentFilter.addAction(ACTION_DESKTOP_CLICK_PLAY);
  		registerReceiver(mBroadcastReceiver, intentFilter);
	}
	//���������ʼ��
	private void ManagerInit()
	{
		UpdateSQLiteMillisecond=60000;//���ݿ���¼��������
		UpdateWidgetMillisecond=10000;//����������¼��������
		if(mDesktopInfos==null)
			CalorieManager.mDesktopInfos=new ArrayList<DesktopInfo>();//��ʼ�������������
		
		mUpdateSQLiteThread=new Thread(mUpdateSQLRunnable);
		mUpdateSQLiteThread.start();
		mUpdateDesktopThread=new Thread(mUpdateDesktopRunnable);
		mUpdateDesktopThread.start();
	}
	//�û���Ϣ��ʼ��
	private void UserInit()
	{
		if(userInfo==null)
			userInfo = new UserInfo();
	}
	//��·�ﲽ����������ʼ��
	private void RegCalorieListenerInit()
	{
		mCalorieListener=new CalorieListener(userInfo.calorieInfo);
		mSensorMgr = (SensorManager)this.getSystemService(android.content.Context.SENSOR_SERVICE );
		this.StartCalc();
	}
	//���ݿ��ʼ��
	private void SQLInit()
	{
		SQLite=new CalorieSQLite(this, "yucalorie.db", null, 1);
		CalorieManager.userInfo=SQLite.GetUserInfo();
		mIsPlayCalorieListener=SQLite.GetCalorieRunState();//�Ƿ�ʼ�ǿ�·��
	}
	
	//��·������Ƿ�����
	public static boolean IsRun()
	{
		return mIsPlayCalorieListener;
	}
	
	//ֹͣ���㿨·��
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
	//��ʼ���㿨·��
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
                	  userInfo.calorieInfo.TodayInit();//��ʼ��calorinfo�ؼ�
                      break;   
             }   
             super.handleMessage(msg);   
        }   
    }; 
	//�������ݵ����ݿ�
	private  Runnable  mUpdateSQLRunnable = new Runnable() {   
       public void run() {
            while (true) { 
            	SQLite.UpdateFrequency(CalorieManager.userInfo);//���²����Ϳ�·��
            	//Log.e("��·��",userInfo.calorieInfo.getFrequency()+"");
            	if(!userInfo.calorieInfo.IsToday())//���calorieinfo���¼�����ں͵�ǰ���ڲ�ͬ�����ʼ��calorieinfo
            	{
            		Message message = new Message();   
                    message.what = 1;
                    mUpdateSQLHandler.sendMessage(message);  
            	}
            	try {   
                    Thread.sleep(CalorieManager.UpdateSQLiteMillisecond);//SQL���¼�������� 
               } catch (InterruptedException e) {   
                    Thread.currentThread().interrupt();   
               }  
            }   
       }   
	};
	
	//���������������
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
                    Thread.sleep(CalorieManager.UpdateWidgetMillisecond);//����������¼�������� 
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
