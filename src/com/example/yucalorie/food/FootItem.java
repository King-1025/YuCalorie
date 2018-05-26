package com.example.yucalorie.food;

import com.example.yucalorie.R;

import android.app.Application;
import android.content.res.Resources;

public class FootItem {
	String Caption;//����
	int UnitNameID;//��λ��
	int Unit;//��λ
	int Calorie;//��·��
	
	public FootItem(String caption,int calorie)
	{//this(caption,calorie,unit,"��",level);
		this(caption,calorie,100);
	}
	
	public FootItem(String caption,int calorie,int unit)
	{//this(caption,calorie,unit,"��",level);
		this(caption,calorie,unit,R.string.name_unit_k);
	}
	
	public FootItem(String caption,int calorie,int unit,int unitnameid)
	{
		this.Calorie=calorie;
		this.Caption=caption;
		this.Unit=unit;
		this.UnitNameID=unitnameid;
	}
}
