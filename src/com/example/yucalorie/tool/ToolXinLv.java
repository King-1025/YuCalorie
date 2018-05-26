package com.example.yucalorie.tool;

import java.math.BigDecimal;

import com.example.yucalorie.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToolXinLv extends Activity {
	TextView mAgeTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.tool_xinlv);
		mAgeTextView=(TextView)this.findViewById(R.id.tool_xinlv_age);
		mAgeTextView.setText("28");
		Button calculateButton=(Button)this.findViewById(R.id.tool_xinlv_calculate);
		calculateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				LinearLayout linearLayout=(LinearLayout)ToolXinLv.this.findViewById(R.id.tool_xinlv_resaultplan);
				linearLayout.setVisibility(View.VISIBLE);
				
				try {
					int age=Integer.parseInt(mAgeTextView.getText().toString());
					//目标心率=（220-年龄）*（60%~80%）
					int resault1=(int)((220-age)*0.6);
					int resault2=(int)((220-age)*0.8);
					
					TextView resault1TextView=(TextView)ToolXinLv.this.findViewById(R.id.tool_xinlv_resault1);
					resault1TextView.setText(resault1+"");
					TextView resault2TextView=(TextView)ToolXinLv.this.findViewById(R.id.tool_xinlv_resault2);
					resault2TextView.setText(resault2+"");
				} catch (Exception e) {
					Toast.makeText(ToolXinLv.this, "请正确输入年龄", 2000);
				}
				
			}
		});
		
		ImageButton backImageButton=(ImageButton)this.findViewById(R.id.tool_xinlv_back);
		backImageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToolXinLv.this.finish();
			}
		});
		super.onCreate(savedInstanceState);
	}
}
