package com.example.yucalorie;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutWidgetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.desktop_about);
		Button backButton=(Button)this.findViewById(R.id.aboutwidget_button_back);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AboutWidgetActivity.this.finish();
			}
		});
		super.onCreate(savedInstanceState);
	}

}
