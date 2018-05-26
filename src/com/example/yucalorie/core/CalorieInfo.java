package com.example.yucalorie.core;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import android.util.Log;

public class CalorieInfo {
	public String Day;
	
	private int mFrequency;//�߲�Ƶ��
	private int mCalorie;//��·��
	private long mWalkingDistance;//���߾���
	private UserInfo mUserInfo;
	
	private Vector mRepository;
	private OnCalorieEventListener mOnCalorieEventListener;
	
	public CalorieInfo(UserInfo user)
	{
		this.mUserInfo=user;
		TodayInit();
		mRepository=new Vector();
	}
	//��ʼ��
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
	
	//����¼�
	public void setOnCalorieEventListener(OnCalorieEventListener listener)
	{
		mRepository.addElement(listener);
	}
	//��ò�����ֵ
	public int getFrequency()
	{
		return this.mFrequency;
	}
	//���ò�����ֵ
	public void setFrequency(int frequency)
	{
		//�����·��ֵ��֮ǰ�Ĳ�һ�����ͳ����¼�
		int oldFrequency=this.mFrequency;
		this.mFrequency=frequency;
		if(oldFrequency!=frequency)
		{
			//Log.e("����", frequency+"");
			Enumeration enume=mRepository.elements();
			while(enume.hasMoreElements())
			{
				mOnCalorieEventListener=(OnCalorieEventListener)enume.nextElement();
				mOnCalorieEventListener.onFrequencyChange(this);
			}
			
			int calorie=CalcCalorie(frequency);//���ݲ������㿨·��
			this.setCalorie(calorie);//�ж��Ƿ񴥷���·��ֵ�ı������
		}
	}
	//���ؿ�·��ֵ
	public int getCalorie()
	{
		return this.mCalorie;
	}
	//���ÿ�·��ֵ
	public void setCalorie(int calorie)
	{
		//�����·��ֵ��֮ǰ�Ĳ�һ�����ͳ����¼�
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
	
	//���㿨·��
	private int CalcCalorie(int frequency)
	{
		//�ܲ�������kcal�������أ�kg�������루�����1.036 
		int resault=(int)((float)mUserInfo.Weight *(float)((float)frequency*(float)mUserInfo.Distance/100000)*1.036/1000);
		return resault;
	}
	
	//��õ�ǰ����
	public static String getNowDate()
	{
		String resault="";
		Calendar c = Calendar.getInstance();
		resault = c.get(Calendar.YEAR)+""; //��ȡ��ǰ���
		resault = resault+"-"+(c.get(Calendar.MONTH)+1);//��ȡ��ǰ�·�
		resault = resault+"-"+c.get(Calendar.DAY_OF_MONTH);//��ȡ��ǰ�·ݵ����ں���
		return resault;
	}
}
