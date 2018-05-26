package com.example.yucalorie;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.pm.PackageManager.*;
import android.content.pm.*;
import android.content.*;
import com.example.yucalorie.king.utils.*;

public class FlashActivity extends Activity
{


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setFullScreen();
	    setContentView(R.layout.activity_flash);
		try
		{
			PackageInfo info=(getPackageManager().getPackageInfo(getPackageName(), 0));
			((TextView)findViewById(R.id.activityflashTextView1)).setText("版本:"+info.versionName);
		}
		catch (PackageManager.NameNotFoundException e)
		{
			e.printStackTrace();
			((TextView)findViewById(R.id.activityflashTextView1)).setText("测试版本");
		}
		
		new Handler().postDelayed(new Runnable(){

				@Override
				public void run()
				{
					// TODO: Implement this method
					if(Checker.hasSession(FlashActivity.this)){
						startActivity(new Intent(FlashActivity.this, MainActivity.class));
					}else{
						startActivity(new Intent(FlashActivity.this, LoginActivity.class));
					}
				    
					finish();
				}
				

		},3000);
	}
	

	private void setFullScreen(){
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);  

	}
	
}
