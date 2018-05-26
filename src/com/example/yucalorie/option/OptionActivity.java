package com.example.yucalorie.option;

import java.util.ArrayList;
import java.util.List;

import com.example.yucalorie.R;
import com.example.yucalorie.core.CalorieManager;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class OptionActivity extends Activity {

	OptionAdapter mAdapter;
	ListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.option_list);
		AdapterInit();
		mListView=(ListView)this.findViewById(R.id.option_listview);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int index,
					long arg3) {
				// TODO Auto-generated method stub
				
				switch (index) {
				case 0://���������������
					onClickStartBootServer(view,index);
					break;
				case 1://�����������
					onClickAge();
					break;
				case 2://�����������
					onClickWeight();
					break;
				case 3://������ò������
					onClickDistance();
					break;
				default:
					break;
				}
			}
		});
		
		ImageButton backButton=(ImageButton)this.findViewById(R.id.option_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				OptionActivity.this.finish();
			}
		});
		super.onCreate(savedInstanceState);
	}
	
	//�������������Ҫ����Ĵ���
	private void onClickStartBootServer(View view,int index)
	{
		ImageView stateImageView=(ImageView)view.findViewById(R.id.optionitem_state_icon);
		OptionItem optionItem=(OptionItem)mAdapter.getItem(index);
		optionItem.Checked=!optionItem.Checked;
		if(optionItem.Checked)
		{
			stateImageView.setBackgroundResource(android.R.drawable.presence_online);
		}
		else {
			stateImageView.setBackgroundResource(android.R.drawable.radiobutton_off_background);
		}
		
	}
	//����û�������Ҫ����Ĵ���
	private void onClickAge()
	{
		String[] arrAge=new String[98];
		for(int i=0;i<arrAge.length;i++)
		{
			arrAge[i]=(i+2)+"��";
		}
		new AlertDialog.Builder(OptionActivity.this)
		.setTitle("��ѡ����������")
		.setIcon(android.R.drawable.ic_dialog_info)                
		.setSingleChoiceItems(arrAge, 0, 
		  new DialogInterface.OnClickListener() {
		                            
		     public void onClick(DialogInterface dialog, int which) {
		    	 dialog.dismiss();  
		     }
		  }
		)
		.setNegativeButton("ȡ��", null)
		.show();
	}
	//����û�������Ҫ����Ĵ���
	private void onClickWeight()
	{
		String[] arrAge=new String[125];
		for(int i=0;i<arrAge.length;i++)
		{
			arrAge[i]=(i+25)+"����";
		}
		new AlertDialog.Builder(OptionActivity.this)
		.setTitle("��ѡ����������")
		.setIcon(android.R.drawable.ic_dialog_info)                
		.setSingleChoiceItems(arrAge, 0, 
		  new DialogInterface.OnClickListener() {
		                            
		     public void onClick(DialogInterface dialog, int which) {
		    	 dialog.dismiss();  
		     }
		  }
		)
		.setNegativeButton("ȡ��", null)
		.show();
	}	
	//����û�������Ҫ����Ĵ���
	private void onClickDistance()
	{
		String[] arrDistance=new String[130];
		for(int i=0;i<arrDistance.length;i++)
		{
			arrDistance[i]=(i+20)+"����";
		}
		new AlertDialog.Builder(OptionActivity.this)
		.setTitle("��ѡ�����Ĳ������")
		.setIcon(android.R.drawable.ic_dialog_info)                
		.setSingleChoiceItems(arrDistance, 0, 
		  new DialogInterface.OnClickListener() {
		                            
		     public void onClick(DialogInterface dialog, int which) {
		    	 dialog.dismiss();  
		     }
		  }
		)
		.setNegativeButton("ȡ��", null)
		.show();
	}
	private void AdapterInit()
	{
		mAdapter = new OptionAdapter(this);
		//����������
		OptionItem bootServerOptionItem = new OptionItem();
		bootServerOptionItem.Caption=this.getResources().getString(R.string.option_bootstart);
		bootServerOptionItem.Text=this.getResources().getString(R.string.option_bootstart_text);
		bootServerOptionItem.StateIcon=android.R.drawable.presence_online;
		mAdapter.AddNewItem(bootServerOptionItem);
		//����û�������
		OptionItem userAgeOptionItem = new OptionItem();
		userAgeOptionItem.Caption=this.getResources().getString(R.string.option_userage);
		userAgeOptionItem.Text=this.getResources().getString(R.string.option_userage_text);
		mAdapter.AddNewItem(userAgeOptionItem);
		//����û�������
		OptionItem userWeightOptionItem = new OptionItem();
		userWeightOptionItem.Caption=this.getResources().getString(R.string.option_userweight);
		userWeightOptionItem.Text=this.getResources().getString(R.string.option_userweight_text);
		mAdapter.AddNewItem(userWeightOptionItem);
		//����û�������
		OptionItem userDistanceOptionItem = new OptionItem();
		userDistanceOptionItem.Caption=this.getResources().getString(R.string.option_userdistance);
		userDistanceOptionItem.Text=this.getResources().getString(R.string.option_userdistance_text);
		mAdapter.AddNewItem(userDistanceOptionItem);
	}

}
