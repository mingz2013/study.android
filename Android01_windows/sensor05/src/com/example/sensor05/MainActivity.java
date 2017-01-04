package com.example.sensor05;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity implements SensorEventListener{

	private SensorManager sensorManager;
	@SuppressWarnings("unused")
	private Sensor mOrientationSensor;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		mOrientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		
		
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float azimuth_angle = event.values[0];
		float pitch_angle = event.values[1];
		float roll_angle = event.values[2];
		
		Toast.makeText(MainActivity.this, "azimuth--->" + azimuth_angle, Toast.LENGTH_LONG).show();
		Toast.makeText(MainActivity.this, "pitch_angle--->" + pitch_angle, Toast.LENGTH_LONG).show();
		Toast.makeText(MainActivity.this, "roll_angle--->" + roll_angle, Toast.LENGTH_LONG).show();
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
		sensorManager.registerListener(this, mOrientationSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	

}
