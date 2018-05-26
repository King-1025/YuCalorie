package com.example.yucalorie.core;

import java.util.ArrayList;
import java.util.List;

import com.example.yucalorie.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class YuImageButtonAdapter extends BaseAdapter {
	List<YuImageButton> mItemButtons;
	private LayoutInflater mInflater;
	public YuImageButtonAdapter(Context context)
	{
		this.mItemButtons=new ArrayList<YuImageButton>();
		this.mInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItemButtons.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mItemButtons.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (arg1==null)
			arg1=this.mInflater.inflate(R.layout.yu_imagebutton, null);
		TextView captionTextView=(TextView)arg1.findViewById(R.id.imagebutton_caption);
		captionTextView.setText(this.mItemButtons.get(arg0).Caption);
		
		ImageView imageView=(ImageView)arg1.findViewById(R.id.imagebutton_img);
		imageView.setImageResource(this.mItemButtons.get(arg0).ImgResID);
		return arg1;
	}
	public void AddNewItem(int res,String caption)
	{
		AddNewItem(res,caption,null);
	}
	public void AddNewItem(int res,String caption,Class<?> cls)
	{
		YuImageButton button = new YuImageButton();
		button.Caption=caption;
		button.ImgResID=res;
		button.cls=cls;
		AddNewItem(button);
	}
	public void AddNewItem(YuImageButton button)
	{
		this.mItemButtons.add(button);
	}
}
