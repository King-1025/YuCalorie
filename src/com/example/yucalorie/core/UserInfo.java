package com.example.yucalorie.core;

public class UserInfo {
	public int Age;//����
	public int Weight;//����(g��)
	public int Distance;//����cm
	public CalorieInfo calorieInfo;
	public UserInfo()
	{
		this.calorieInfo=new CalorieInfo(this);
		this.Weight=75000;//Ĭ��75����
		this.Distance=50;//����Ĭ��50����
	}
}
