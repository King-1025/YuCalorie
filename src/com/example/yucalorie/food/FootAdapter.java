package com.example.yucalorie.food;

import java.util.ArrayList;
import java.util.List;

import com.example.yucalorie.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FootAdapter extends BaseAdapter {
	List<FootItem> mItems;
	private LayoutInflater mInflater;
	Context mContext;
	public FootAdapter(Context context)
	{
		this.mContext=context;
		this.mItems=new ArrayList<FootItem>();
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
		this.mItems.get(arg0);
		return null;
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
			arg1=this.mInflater.inflate(R.layout.food_item, null);
		TextView captionTextView=(TextView)arg1.findViewById(R.id.footdata_caption);
		captionTextView.setText(this.mItems.get(arg0).Caption);
		
		TextView calorieTextView=(TextView)arg1.findViewById(R.id.footdata_calorie);
		calorieTextView.setText(this.mItems.get(arg0).Calorie+"");
		
		TextView unitTextView=(TextView)arg1.findViewById(R.id.footdata_unit);
		unitTextView.setText(this.mItems.get(arg0).Unit+"");
		
		TextView unitnameTextView=(TextView)arg1.findViewById(R.id.footdata_unitname);
		unitnameTextView.setText(mContext.getString(this.mItems.get(arg0).UnitNameID));
		
		TextView levelTextView=(TextView)arg1.findViewById(R.id.footdata_level);
		String levelTextString="";
		if(this.mItems.get(arg0).Calorie<101)
			levelTextString="四星减肥食品，单位热量较低";
		else if(this.mItems.get(arg0).Calorie<201){
			levelTextString="三星减肥食品，单位热量适中";
		}
		else if(this.mItems.get(arg0).Calorie<401){
			levelTextString="二星减肥食品，单位热量较高";
		}else {
			levelTextString="一星减肥食品，单位热量偏高,减肥不宜多食";
		}
		levelTextView.setText(levelTextString);
		return arg1;
	}
	public void AddNewItem(FootItem foot)
	{
		this.mItems.add(foot);
	}

}
