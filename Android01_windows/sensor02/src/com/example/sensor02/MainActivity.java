package com.example.sensor02;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {
	// 声明一个Sensor对象
	private SensorManager sensorManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 获取对象
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		// 获取光线传感器对象
		Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		// 注册传感器	匿名内部类
		sensorManager.registerListener(new SensorEventListener() {
			
			@Override
			// 当传感器感知到外界的环境的变化时调用该方法
			public void onSensorChanged(SensorEvent event) {
				// 接收到事件event，里面有一些数据，
				// 精度
				float acc = event.accuracy;
				// 这里values里面的第0个值代表的是光线的强度
				float lux = event.values[0];
				
				Toast.makeText(MainActivity.this, "acc----->" + acc, Toast.LENGTH_LONG).show();
				System.out.println("acc----->" + acc);
				Toast.makeText(MainActivity.this, "lux----->" + lux, Toast.LENGTH_LONG).show();
				System.out.println("lux----->" + lux);
				
			}
			
			@Override
			// 当传感器的精度出现变化的时候
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
			
		}, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
		
	}


}
