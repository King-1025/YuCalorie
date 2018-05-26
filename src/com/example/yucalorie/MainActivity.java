package com.example.yucalorie;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.yucalorie.core.CalorieInfo;
import com.example.yucalorie.core.CalorieManager;
import com.example.yucalorie.core.OnCalorieEventListener;
import com.example.yucalorie.core.YuImageButton;
import com.example.yucalorie.core.YuImageButtonAdapter;
import com.example.yucalorie.food.FootTypeListActivity;
import com.example.yucalorie.note.NoteListActivity;
import com.example.yucalorie.option.OptionActivity;
import com.example.yucalorie.picturelist.PictureListMainActivity;
import com.example.yucalorie.tool.ToolMainListActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView mFrequencyTextView;//������ʾ
	private TextView mToDayTextView;//������ʾ
	private TextView mCalorieTextView;//��·����ʾ
	private GridView mButtonTableLayout;//�Ź���ť
	private YuImageButtonAdapter mTableButtonAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent = new Intent(this, CalorieManager.class);
		this.startService(intent);
		
		ControlInit();

		if (CalorieManager.userInfo==null)  return;
		mToDayTextView.setText(CalorieManager.userInfo.calorieInfo.Day);
		mFrequencyTextView.setText(CalorieManager.userInfo.calorieInfo.getFrequency()+"");
		mCalorieTextView.setText(CalorieManager.userInfo.calorieInfo.getCalorie()+"");
		CalorieManager.userInfo.calorieInfo.setOnCalorieEventListener(new OnCalorieEventListener()
		{
			public void onFrequencyChange(CalorieInfo calorieInfo)
			{
				mFrequencyTextView.setText(calorieInfo.getFrequency()+"");
			}
			public void onCalorieChange(CalorieInfo calorieInfo)
			{
				mCalorieTextView.setText(calorieInfo.getCalorie()+"");
			}
		});
	}
	
	//�����ʼ��
	private void ControlInit()
	{
		if(mButtonTableLayout==null)
			mButtonTableLayout=(GridView)this.findViewById(R.id.main_buttontable);
		if(mTableButtonAdapter==null)
		{
			mTableButtonAdapter=new YuImageButtonAdapter(this);
			
			mTableButtonAdapter.AddNewItem(R.drawable.icon_calculator,
					this.getResources().getString(R.string.toolmain_caption),ToolMainListActivity.class);
			mTableButtonAdapter.AddNewItem(R.drawable.icon_note,this.getResources().getString(R.string.note),NoteListActivity.class);
			mTableButtonAdapter.AddNewItem(R.drawable.icon_look,this.getResources().getString(R.string.look),PictureListMainActivity.class);
			mTableButtonAdapter.AddNewItem(R.drawable.icon_food,this.getResources().getString(R.string.food),FootTypeListActivity.class);
			mTableButtonAdapter.AddNewItem(R.drawable.icon_option,
					this.getResources().getString(R.string.option_caption),OptionActivity.class);
			mTableButtonAdapter.AddNewItem(R.drawable.icon_widget,this.getResources().getString(R.string.widget),AboutWidgetActivity.class);
			mButtonTableLayout.setAdapter(mTableButtonAdapter);
			
			mButtonTableLayout.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					YuImageButton button=(YuImageButton)mTableButtonAdapter.getItem(arg2);
					if(button.cls!=null)
					{
						Intent intent = new Intent(MainActivity.this,button.cls);
						MainActivity.this.startActivity(intent);
					}
				}
			});
			
		}
		if(mToDayTextView==null)
		{
			mToDayTextView=(TextView)this.findViewById(R.id.main_today);
			/*Date now=new Date();
			SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd");
			String strDate=temp.format(now);*/
			mToDayTextView.setText(CalorieInfo.getNowDate());
		}
		if(mFrequencyTextView==null)
		{
			mFrequencyTextView=(TextView)this.findViewById(R.id.main_frequency);
		}
		if(mCalorieTextView==null)
		{
			mCalorieTextView=(TextView)this.findViewById(R.id.main_calorie);
		}
		ImageButton aboutButton=(ImageButton)this.findViewById(R.id.main_button_about);
		aboutButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,AboutActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		ImageButton exitButton=(ImageButton)this.findViewById(R.id.main_button_exit);
		exitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
				Intent intent=new Intent(MainActivity.this,LoginActivity.class);
				intent.putExtra(MyApplication.FLAG_EXIT,true);
			    startActivity(intent);
			}
		});
		//���ռǽ���
		/*Button noteButton=(Button)this.findViewById(R.id.main_button_note);
		noteButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent noteIntent = new Intent(MainActivity.this,NoteListActivity.class);
				MainActivity.this.startActivity(noteIntent);
			}
		});*/
		//�����ý���
		/*ImageButton optionButton=(ImageButton)this.findViewById(R.id.main_button_option);
		optionButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent optionIntent = new Intent(MainActivity.this,OptionActivity.class);
				MainActivity.this.startActivity(optionIntent);
			}
		});*/
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//this.stopService(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
