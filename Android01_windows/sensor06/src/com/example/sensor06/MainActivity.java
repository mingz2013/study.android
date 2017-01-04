package com.example.sensor06;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
// 继承一个接口
public class MainActivity extends Activity implements SensorEventListener{
	private SensorManager sensorManager;
	private Sensor mProximity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		// 距离传感器
		mProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float distance = event.values[0];
		Toast.makeText(MainActivity.this, "distance--->" + distance, Toast.LENGTH_LONG).show();
		Toast.makeText(MainActivity.this, "" + mProximity.getMaximumRange(), Toast.LENGTH_LONG).show();
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sensorManager.unregisterListener(this);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
	}


}
