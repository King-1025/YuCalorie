package com.example.yucalorie.option;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yucalorie.R;
import com.example.yucalorie.note.NoteItem;

public class OptionAdapter extends BaseAdapter {
	List<OptionItem> mItems;
	private LayoutInflater mInflater;
	public OptionAdapter(Context context)
	{
		mItems=new ArrayList<OptionItem>();
		this.mInflater = LayoutInflater.from(context);
		//JiBuServiceManager.jiBuSQLite.LoadNote(this);//从数据库读取数据日记
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		if (arg1==null)
			arg1=this.mInflater.inflate(R.layout.option_item, null);
		
		TextView captionTextView=(TextView)arg1.findViewById(R.id.optionitem_caption);
		captionTextView.setText(this.mItems.get(arg0).Caption);
		
		TextView textTextView=(TextView)arg1.findViewById(R.id.optionitem_text);
		textTextView.setText(this.mItems.get(arg0).Text);
		
		if(this.mItems.get(arg0).StateIcon>0)
		{
			ImageView stateImageView=(ImageView)arg1.findViewById(R.id.optionitem_state_icon);
			stateImageView.setBackgroundResource(this.mItems.get(arg0).StateIcon);
		}
		return arg1;
	}
	
	public void AddNewItem(OptionItem option)
	{
		this.mItems.add(option);
	}
}
