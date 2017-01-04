package com.example.sensor04;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {
	private SensorManager sensorManager = null;
	private Sensor accelerometerSensor = null;
	// 重力加速度数组，代表三个方向的
	private float gravity[] = new float[3];
	// 直线加速度数组
	private float linear_acceleration[] = new float[3];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		// 加速度传感器
		accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				/*/ x,y,z,三个方向的加速度对应数组的 0，1，2
				Toast.makeText(MainActivity.this, "0----->" + event.values[0], Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "1----->" + event.values[1], Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "2----->" + event.values[2], Toast.LENGTH_LONG).show();
				*/
				final float alpha = 0.8f;
				// 这里得到重力在三个方向的真实重力
				gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
				gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
				gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
				// 得到三个方向的真实加速度
				linear_acceleration[0] = event.values[0] - gravity[0];
				linear_acceleration[1] = event.values[1] - gravity[1];
				linear_acceleration[2] = event.values[2] - gravity[2];
				
				Toast.makeText(MainActivity.this, "" + linear_acceleration[0], Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "" + linear_acceleration[1], Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, "" + linear_acceleration[2], Toast.LENGTH_LONG).show();
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		}, accelerometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
	}

}
