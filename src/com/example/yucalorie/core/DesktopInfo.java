package com.example.yucalorie.core;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.widget.RemoteViews;

public class DesktopInfo {
	RemoteViews remoteViews;
	AppWidgetManager appWidgetManager;
	Context context;
	Class<?> Class;
	public DesktopInfo(Context c,AppWidgetManager a,RemoteViews r,Class<?> cls) {
		// TODO Auto-generated constructor stub
		this.remoteViews=r;
		this.appWidgetManager=a;
		this.context=c;
		this.Class=cls;
	}
}
