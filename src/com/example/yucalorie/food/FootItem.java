package com.example.yucalorie.food;

import com.example.yucalorie.R;

import android.app.Application;
import android.content.res.Resources;

public class FootItem {
	String Caption;//名称
	int UnitNameID;//单位名
	int Unit;//单位
	int Calorie;//卡路里
	
	public FootItem(String caption,int calorie)
	{//this(caption,calorie,unit,"克",level);
		this(caption,calorie,100);
	}
	
	public FootItem(String caption,int calorie,int unit)
	{//this(caption,calorie,unit,"克",level);
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
