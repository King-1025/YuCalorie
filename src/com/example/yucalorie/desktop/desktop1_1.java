package com.example.yucalorie.desktop;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.yucalorie.MainActivity;
import com.example.yucalorie.R;
import com.example.yucalorie.core.CalorieManager;

public class desktop1_1 extends AppWidgetProvider {

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(context,CalorieManager.class);
		context.startService(intent);
		
		RemoteViews remoteViews= new RemoteViews(context.getPackageName(), R.layout.desktop1_1);	
		CalorieManager.AddDesktop(context, appWidgetManager, 
				remoteViews, desktop1_1.class);
		
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
		
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

}
