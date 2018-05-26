package com.example.yucalorie.picturelist;

import java.util.ArrayList;
import java.util.List;

import com.example.yucalorie.R;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class PictureListActivity extends Activity {
	List<Integer> mPicListIDs;
	ImageView mImageView;
	int mPerRnd=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.picturelist);
		this.mImageView=(ImageView)this.findViewById(R.id.picturelist_img);
		if(mPicListIDs==null)
		{
			mPicListIDs=new ArrayList<Integer>();
			
			Intent intent = this.getIntent();
			int typeid=intent.getIntExtra("type", 1);
			if(typeid==1)
			{
				mPicListIDs.add(new Integer(R.drawable.pic1_1));
				mPicListIDs.add(new Integer(R.drawable.pic1_2));
				mPicListIDs.add(new Integer(R.drawable.pic1_3));
				mPicListIDs.add(new Integer(R.drawable.pic1_4));
				mPicListIDs.add(new Integer(R.drawable.pic1_5));
			}
			else {
				mPicListIDs.add(new Integer(R.drawable.pic2_1));
				mPicListIDs.add(new Integer(R.drawable.pic2_2));
				mPicListIDs.add(new Integer(R.drawable.pic2_3));
				mPicListIDs.add(new Integer(R.drawable.pic2_4));
			}
		}
		RndShowImg();
		
		Button rndImgButton=(Button)this.findViewById(R.id.picture_button_next);
		rndImgButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RndShowImg();
			}
		});
		
		Button backImgButton=(Button)this.findViewById(R.id.picture_button_back);
		backImgButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PictureListActivity.this.finish();
			}
		});
		super.onCreate(savedInstanceState);
	}

	private int RndShowImg()
	{
		int rnd=GetRndInt();
		mImageView.setImageResource(mPicListIDs.get(rnd));
		return rnd;
	}
	
	private int GetRndInt()
	{
		int rnd=0;
		do {
			rnd=(int)(Math.random() * mPicListIDs.size());
		} while (rnd==mPerRnd);
		mPerRnd=rnd;
		return rnd;
	}
}
