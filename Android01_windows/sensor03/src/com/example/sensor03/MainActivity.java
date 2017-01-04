package com.example.sensor03;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class MainActivity extends Activity {
	private SensorManager sensorManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		Sensor lightSensor = (Sensor)sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		
		sensorManager.registerListener(new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				/**
				 * 1.传感器名称
				 * 2.传感器制造商
				 * 3.传感器功率	----
				 * 4.传感器的resulotion	----分辨率，比如光线传感器能识别的最小光线变化的大小
				 * */
				String sensorName = event.sensor.getName();
				String sensorVendor = event.sensor.getVendor();
				float resolution = event.sensor.getResolution();
				float power = event.sensor.getPower();
				double timestamp = event.timestamp;
				
				System.out.println("sensor name--->" + sensorName);
				System.out.println("sensor vendor--->" + sensorVendor);
				System.out.println("sensor resolution--->" + resolution);
				System.out.println("sensor power--->" + power);
				System.out.println("sensor timestamp--->" + timestamp);// 时间戳
				
				Toast.makeText(MainActivity.this, "sensor name--->" + sensorName, Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "sensor vendor--->" + sensorVendor, Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "sensor resolution--->" + resolution, Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "sensor power--->" + power, Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "sensor timestamp--->" + timestamp, Toast.LENGTH_LONG).show();
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		}, lightSensor, SensorManager.SENSOR_DELAY_GAME);// 最后一个参数用来设置传感器的采样率
	}



}
