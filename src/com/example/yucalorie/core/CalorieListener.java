package com.example.yucalorie.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class CalorieListener implements SensorEventListener {

	CalorieInfo mCalorieInfo;
	float[] preCoordinate;
	double currentTime=0,lastTime=0;//记录时间
	float WALKING_THRESHOLD=20;
	
	public CalorieListener(CalorieInfo calorieInfo)
	{
		this.mCalorieInfo=calorieInfo;
	}
	
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
		{
			analyseDate(arg0.values);//调用方法分析数据
		}
	}
	  
	public void analyseDate(float[] values)
	{
		//获取当前时间
		currentTime=System.currentTimeMillis();
		//每个200ms取加速度力和前一个进行比较
		if(currentTime-lastTime>200)
		{
			if(preCoordinate==null)//还未存储过数据
			{
				preCoordinate=new float[3];
				
			}else {
				int angle=calculateAngle(values, preCoordinate);
				//Log.e("几步判断",angle+"/"+WALKING_THRESHOLD);
				if(angle>=WALKING_THRESHOLD)
				{
					int frequency=mCalorieInfo.getFrequency();
					mCalorieInfo.setFrequency(++frequency);
				}
			}
			for(int i=0;i<3;i++)
			{
				preCoordinate[i]=values[i];
			}
			lastTime=currentTime;//重新计时
		}
	}
	
	  public int calculateAngle(float[] newPoints,float[] oldPoints)
	  {
			int angle=0;
			float vectorProduct=0;//向量积
			float newMold=0;//新向量的模
			float oldMold=0;//旧向量的模
			for(int i=0;i<3;i++)
			{
				vectorProduct+=newPoints[i]*oldPoints[i];
				newMold+=newPoints[i]*newPoints[i];
				oldMold+=oldPoints[i]*oldPoints[i];
			}
			newMold=(float)Math.sqrt(newMold);
			oldMold=(float)Math.sqrt(oldMold);
			//计算夹角的余弦
			float cosineAngle=(float)(vectorProduct/(newMold*oldMold));
			//通过余弦值求角度
			float fange=(float)Math.toDegrees(Math.acos(cosineAngle));
			angle=(int)fange;
			return angle;//返回向量的夹角
	  }

}