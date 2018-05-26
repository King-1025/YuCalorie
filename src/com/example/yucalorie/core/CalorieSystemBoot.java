package com.example.yucalorie.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CalorieSystemBoot extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		//启动后台记步程序
        Intent myintent=new Intent(context,CalorieManager.class);
        context.startService(myintent);
	}

}
