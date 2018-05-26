package com.example.yucalorie.food;

import com.example.yucalorie.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class FootTypeListActivity extends Activity {
	private FootTypeAdapter mAdapter;
	private ListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.food_typelist);
		AdapterInit();
		
		ImageButton backButton=(ImageButton)this.findViewById(R.id.foottype_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FootTypeListActivity.this.finish();
			}
		});
		
		super.onCreate(savedInstanceState);
	}
	
	private void AdapterInit()
	{
		if(mListView==null)
			mListView=(ListView)this.findViewById(R.id.foottype_listview);
		if(mAdapter==null)
		{
			mAdapter=new FootTypeAdapter(this);
			mAdapter.AddNewItem(new FootTypeItem(0, "早餐",0));
			mAdapter.AddNewItem(new FootTypeItem(0, "面包",1));
			mAdapter.AddNewItem(new FootTypeItem(0, "米饭",2));
			mAdapter.AddNewItem(new FootTypeItem(0, "水果",3));
			mAdapter.AddNewItem(new FootTypeItem(0, "蔬菜",4));
			mAdapter.AddNewItem(new FootTypeItem(0, "零食",5));
			mAdapter.AddNewItem(new FootTypeItem(0, "饼干",6));
			//mAdapter.AddNewItem(new FootTypeItem(0, "朱古力",7));
			mAdapter.AddNewItem(new FootTypeItem(0, "雪糕",8));
			mAdapter.AddNewItem(new FootTypeItem(0, "糖果",9));
			mAdapter.AddNewItem(new FootTypeItem(0, "干果",10));
			mAdapter.AddNewItem(new FootTypeItem(0, "奶类",11));
			mAdapter.AddNewItem(new FootTypeItem(0, "饮料",12));
			mAdapter.AddNewItem(new FootTypeItem(0, "酒类",13));
			mAdapter.AddNewItem(new FootTypeItem(0, "主食",14));
			mAdapter.AddNewItem(new FootTypeItem(0, "糕点",15));
			mAdapter.AddNewItem(new FootTypeItem(0, "调味",16));
		}
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				FootTypeItem typeItem=(FootTypeItem)mAdapter.getItem(arg2);
				Intent intent = new Intent(FootTypeListActivity.this,FootDataActivity.class);
				if(typeItem!=null)
				{
					intent.putExtra("type", typeItem.TypeID);
					intent.putExtra("caption", typeItem.Caption);
				}
				FootTypeListActivity.this.startActivity(intent);
			}
		});
	}

}
