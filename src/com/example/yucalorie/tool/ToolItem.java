package com.example.yucalorie.tool;

public class ToolItem {
	int IconResID;
	String Caption;
	Class<?> cls;
	
	public ToolItem(int iconID,String caption)
	{
		this(iconID, caption, null);
	}
	public ToolItem(int iconID,String caption,Class<?> c)
	{
		this.IconResID=iconID;
		this.Caption=caption;
		this.cls=c;
	}
}
