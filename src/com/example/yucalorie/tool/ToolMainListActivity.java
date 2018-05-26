package com.example.yucalorie.tool;

import com.example.yucalorie.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class ToolMainListActivity extends Activity{

	ListView mListView;
	ToolAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.tool_list);
		AdapterInit();
		
		ImageButton backButton=(ImageButton)this.findViewById(R.id.tool_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToolMainListActivity.this.finish();
			}
		});
		super.onCreate(savedInstanceState);
	}
	
	private void AdapterInit()
	{
		if(mListView==null)
			mListView=(ListView)this.findViewById(R.id.tool_listview);
		if(mAdapter==null)
		{
			mAdapter=new ToolAdapter(this);
			mAdapter.AddNewItem(new ToolItem(0, "体重指数(BMI)",ToolBMI.class));
			//mAdapter.AddNewItem(new ToolItem(0, "标准体重计算器"));
			mAdapter.AddNewItem(new ToolItem(0, "有氧运动心率",ToolXinLv.class));
			//mAdapter.AddNewItem(new ToolItem(0, "基础代谢计算"));
			//mAdapter.AddNewItem(new ToolItem(0, "身高体重标准"));
			//mAdapter.AddNewItem(new ToolItem(0, "女性安全期计算"));
			//mAdapter.AddNewItem(new ToolItem(0, "预产期计算"));
			mListView.setAdapter(mAdapter);
			
		}
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				ToolItem toolItem=(ToolItem)mAdapter.getItem(arg2);
				if(toolItem!=null && toolItem.cls!=null)
				{
					Intent intent=new Intent(ToolMainListActivity.this,toolItem.cls);
					ToolMainListActivity.this.startActivity(intent);
				}
			}
		});
	}

}
