package com.example.yucalorie.food;

import java.util.ArrayList;
import java.util.List;

import com.example.yucalorie.R;
import com.example.yucalorie.core.YuImageButton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FootTypeAdapter extends BaseAdapter {
	List<FootTypeItem> mItems;
	private LayoutInflater mInflater;
	public FootTypeAdapter(Context context)
	{
		this.mItems=new ArrayList<FootTypeItem>();
		this.mInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.mItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.mItems.get(arg0);
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
			arg1=this.mInflater.inflate(R.layout.foodtype_item, null);
		TextView captionTextView=(TextView)arg1.findViewById(R.id.foodtype_caption);
		captionTextView.setText(this.mItems.get(arg0).Caption);
		
		return arg1;
	}
	public void AddNewItem(FootTypeItem foottype)
	{
		this.mItems.add(foottype);
	}
}
