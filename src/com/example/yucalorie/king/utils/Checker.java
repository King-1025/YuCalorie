package com.example.yucalorie.king.utils;
import android.content.*;
import com.example.yucalorie.*;
import com.example.yucalorie.king.manager.*;

public class Checker
{
	public static void saveSession(Context context,String nick,String passwd){
		if(context!=null){
			SharedPreferences sp=context.getApplicationContext().
			       getSharedPreferences(MyApplication.SESSION_NAME,context.MODE_PRIVATE);
			SharedPreferences.Editor editor = sp.edit();
			editor.putString(MyApplication.KEY_NAME,nick);
			editor.putString(MyApplication.KEY_ORDER,passwd);
			editor.commit();
		}
	}
	
	public static boolean hasSession(Context context){
		boolean is=false;
		if(context!=null){
			SharedPreferences sp=context.getApplicationContext().
				getSharedPreferences(MyApplication.SESSION_NAME,context.MODE_PRIVATE);
				is=new AccountManager(context).login(sp.getString(MyApplication.KEY_NAME,""),
				sp.getString(MyApplication.KEY_ORDER,""));
		}
		return is;
	}
	
	public static void cleanSession(Context context){
		saveSession(context,"","");
	}
	
}
