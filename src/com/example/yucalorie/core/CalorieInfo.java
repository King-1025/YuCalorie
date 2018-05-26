package com.example.yucalorie.core;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import android.util.Log;

public class CalorieInfo {
	public String Day;
	
	private int mFrequency;//走步频率
	private int mCalorie;//卡路里
	private long mWalkingDistance;//行走距离
	private UserInfo mUserInfo;
	
	private Vector mRepository;
	private OnCalorieEventListener mOnCalorieEventListener;
	
	public CalorieInfo(UserInfo user)
	{
		this.mUserInfo=user;
		TodayInit();
		mRepository=new Vector();
	}
	//初始化
	public void TodayInit()
	{
		this.Day=getNowDate();
		setFrequency(0);
	}
	public boolean IsToday()
	{
		String nowDateString=this.getNowDate();
		if(this.Day.equals(nowDateString))
		{
			return true;
		}
		return false;
	}
	
	//添加事件
	public void setOnCalorieEventListener(OnCalorieEventListener listener)
	{
		mRepository.addElement(listener);
	}
	//获得步幅数值
	public int getFrequency()
	{
		return this.mFrequency;
	}
	//设置步幅数值
	public void setFrequency(int frequency)
	{
		//如果卡路里值和之前的不一样，就出发事件
		int oldFrequency=this.mFrequency;
		this.mFrequency=frequency;
		if(oldFrequency!=frequency)
		{
			//Log.e("步数", frequency+"");
			Enumeration enume=mRepository.elements();
			while(enume.hasMoreElements())
			{
				mOnCalorieEventListener=(OnCalorieEventListener)enume.nextElement();
				mOnCalorieEventListener.onFrequencyChange(this);
			}
			
			int calorie=CalcCalorie(frequency);//根据步数计算卡路里
			this.setCalorie(calorie);//判断是否触发卡路里值改变的驱动
		}
	}
	//返回卡路里值
	public int getCalorie()
	{
		return this.mCalorie;
	}
	//设置卡路里值
	public void setCalorie(int calorie)
	{
		//如果卡路里值和之前的不一样，就出发事件
		int oldCalorie=this.mCalorie;
		this.mCalorie=calorie;
		if(oldCalorie!=calorie)
		{
			Enumeration enume=mRepository.elements();
			while(enume.hasMoreElements())
			{
				mOnCalorieEventListener=(OnCalorieEventListener)enume.nextElement();
				mOnCalorieEventListener.onCalorieChange(this);
			}
		}
	}
	
	//计算卡路里
	private int CalcCalorie(int frequency)
	{
		//跑步热量（kcal）＝体重（kg）×距离（公里）×1.036 
		int resault=(int)((float)mUserInfo.Weight *(float)((float)frequency*(float)mUserInfo.Distance/100000)*1.036/1000);
		return resault;
	}
	
	//获得当前日期
	public static String getNowDate()
	{
		String resault="";
		Calendar c = Calendar.getInstance();
		resault = c.get(Calendar.YEAR)+""; //获取当前年份
		resault = resault+"-"+(c.get(Calendar.MONTH)+1);//获取当前月份
		resault = resault+"-"+c.get(Calendar.DAY_OF_MONTH);//获取当前月份的日期号码
		return resault;
	}
}
