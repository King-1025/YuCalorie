package com.example.yucalorie.core;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class CalorieListener implements SensorEventListener {

	CalorieInfo mCalorieInfo;
	float[] preCoordinate;
	double currentTime=0,lastTime=0;//��¼ʱ��
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
			analyseDate(arg0.values);//���÷�����������
		}
	}
	  
	public void analyseDate(float[] values)
	{
		//��ȡ��ǰʱ��
		currentTime=System.currentTimeMillis();
		//ÿ��200msȡ���ٶ�����ǰһ�����бȽ�
		if(currentTime-lastTime>200)
		{
			if(preCoordinate==null)//��δ�洢������
			{
				preCoordinate=new float[3];
				
			}else {
				int angle=calculateAngle(values, preCoordinate);
				//Log.e("�����ж�",angle+"/"+WALKING_THRESHOLD);
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
			lastTime=currentTime;//���¼�ʱ
		}
	}
	
	  public int calculateAngle(float[] newPoints,float[] oldPoints)
	  {
			int angle=0;
			float vectorProduct=0;//������
			float newMold=0;//��������ģ
			float oldMold=0;//��������ģ
			for(int i=0;i<3;i++)
			{
				vectorProduct+=newPoints[i]*oldPoints[i];
				newMold+=newPoints[i]*newPoints[i];
				oldMold+=oldPoints[i]*oldPoints[i];
			}
			newMold=(float)Math.sqrt(newMold);
			oldMold=(float)Math.sqrt(oldMold);
			//����нǵ�����
			float cosineAngle=(float)(vectorProduct/(newMold*oldMold));
			//ͨ������ֵ��Ƕ�
			float fange=(float)Math.toDegrees(Math.acos(cosineAngle));
			angle=(int)fange;
			return angle;//���������ļн�
	  }

}