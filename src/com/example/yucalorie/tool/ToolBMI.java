package com.example.yucalorie.tool;

import java.math.BigDecimal;

import com.example.yucalorie.R;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ToolBMI extends Activity {

	TextView mGaoTextView;
	TextView mZhongTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.tool_bmi);
		mGaoTextView=(TextView)ToolBMI.this.findViewById(R.id.tool_bmi_shengao);
		mGaoTextView.setText("173");
		mZhongTextView=(TextView)ToolBMI.this.findViewById(R.id.tool_bmi_tizhong);
		mZhongTextView.setText("75");
		Button calculateButton=(Button)this.findViewById(R.id.tool_bmi_calculate);
		calculateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				LinearLayout linearLayout=(LinearLayout)ToolBMI.this.findViewById(R.id.tool_bmi_resaultplan);
				linearLayout.setVisibility(View.VISIBLE);
				
				double shengao=Double.parseDouble(mGaoTextView.getText().toString())/100;
				double tizhong=Double.parseDouble(mZhongTextView.getText().toString());
				double resault= tizhong/ (shengao*shengao);
				BigDecimal bg = new BigDecimal(resault); 
				resault = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
				String TiZhi="";
				if(resault<18.5)
					TiZhi="轻体重";
				else if(resault<24)
					TiZhi="健康体重";
				else if(resault<28)
					TiZhi="超重";
				else 
					TiZhi="肥胖";
				TextView resaultTextView=(TextView)ToolBMI.this.findViewById(R.id.tool_bmi_resault);
				resaultTextView.setText(resault+"("+TiZhi+")");
			}
		});
		
		ImageButton backImageButton=(ImageButton)this.findViewById(R.id.tool_bmi_back);
		backImageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToolBMI.this.finish();
			}
		});
		super.onCreate(savedInstanceState);
	}

}
