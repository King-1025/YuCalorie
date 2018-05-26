package com.example.yucalorie.desktop;

import com.example.yucalorie.MainActivity;
import com.example.yucalorie.R;
import com.example.yucalorie.core.CalorieManager;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class desktop1_2 extends AppWidgetProvider {

	private String PRO_STATE="pro_state";

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		RemoteViews remoteViews= new RemoteViews(context.getPackageName(), R.layout.desktop1_2);
		// TODO Auto-generated method stub
		Intent intent=new Intent(context,CalorieManager.class);
		context.startService(intent);
		
		CalorieManager.AddDesktop(context, appWidgetManager, 
				remoteViews, desktop1_2.class);
		
		//设置点击停止或者运行卡路里计算的广播
		Intent playIntent = new Intent(CalorieManager.ACTION_DESKTOP_CLICK_PLAY);
		
		//设置pendingIntent的作用
		PendingIntent playPending = PendingIntent.getBroadcast(context, 0, playIntent, 0);
		remoteViews.setOnClickPendingIntent(R.id.desktop_playbutton, playPending);
		
		//点击进入主界面
		for (int i=0; i<appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];
            Intent intentClick = new Intent(context,MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentClick, 0);
            remoteViews.setOnClickPendingIntent(R.id.desktop_calorie_icon, pendingIntent);
    		remoteViews.setOnClickPendingIntent(R.id.desktop_calorie, pendingIntent);
    		remoteViews.setOnClickPendingIntent(R.id.desktop_frequency, pendingIntent);
    		remoteViews.setOnClickPendingIntent(R.id.desktop_frequency_icon, pendingIntent);
    		remoteViews.setOnClickPendingIntent(R.id.desktop_data_panel, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
		//设置按钮状态
		/*if(!CalorieManager.IsRun())
		{
			remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_play);
		}
		else {
			remoteViews.setImageViewResource(R.id.desktop_playbutton, R.drawable.button_stop);
		}
		Log.e("onUpdate", "onUpdate");*/
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

}
