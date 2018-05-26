package com.example.yucalorie.food;

public class FootTypeItem {
	int TypeIconResID;//资源图标ID
	String Caption;//标题
	int TypeID;//类型ID
	public FootTypeItem(int type,String caption,int typeid)
	{
		this.TypeIconResID=type;
		this.Caption=caption;
		this.TypeID=typeid;
	}
}
