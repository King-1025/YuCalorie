package com.example.yucalorie.core;

public class UserInfo {
	public int Age;//年龄
	public int Weight;//体重(g克)
	public int Distance;//步幅cm
	public CalorieInfo calorieInfo;
	public UserInfo()
	{
		this.calorieInfo=new CalorieInfo(this);
		this.Weight=75000;//默认75公斤
		this.Distance=50;//步幅默认50厘米
	}
}
