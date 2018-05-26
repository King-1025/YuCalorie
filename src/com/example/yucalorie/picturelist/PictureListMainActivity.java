package com.example.yucalorie.picturelist;

import com.example.yucalorie.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PictureListMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.picturemain_list);
		
		Button goPic1Button=(Button)this.findViewById(R.id.picturemain_button_open1);
		goPic1Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(PictureListMainActivity.this,PictureListActivity.class);
				intent.putExtra("type", 1);
				PictureListMainActivity.this.startActivity(intent);
			}
		});
		Button goPic2Button=(Button)this.findViewById(R.id.picturemain_button_open2);
		goPic2Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(PictureListMainActivity.this,PictureListActivity.class);
				intent.putExtra("type", 2);
				PictureListMainActivity.this.startActivity(intent);
			}
		});
		
		Button backButton=(Button)this.findViewById(R.id.picturemain_button_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PictureListMainActivity.this.finish();
			}
		});
		
		super.onCreate(savedInstanceState);
	}

}
