package com.example.yucalorie.king.utils;

import android.content.*;
import android.database.sqlite.*;
import android.util.*;
import com.example.yucalorie.king.manager.*;
import com.example.yucalorie.*;

public class SimpleSQLiteOpenHelper extends SQLiteOpenHelper
{

	private Context context;
	private final static String DB_NAME=MyApplication.DB_NAME;
	private final static int VERSION=1;
	
	private final static String TAG="SimpleSQLiteOpenHelper";
	public SimpleSQLiteOpenHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
		this.context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase p1)
	{
		// TODO: Implement this method
		p1.execSQL(AccountManager.DEFAULT_CREATE_TABLE_SQL);
		Log.i(TAG,"已创建用户表");
	}

	@Override
	public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
	{
		// TODO: Implement this method
	}
	
	public static void execSQL(Context context,String sql,boolean isWritable){
		if(context==null||sql==null)return;
		SQLiteDatabase db;
		if(isWritable){
			db=new SimpleSQLiteOpenHelper(context).getWritableDatabase();
		}else{
			db=new SimpleSQLiteOpenHelper(context).getReadableDatabase();
		}
		db.execSQL(sql);
		db.close();
	}
	
}
