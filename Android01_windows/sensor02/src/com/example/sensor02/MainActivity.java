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
	// ����һ��Sensor����
	private SensorManager sensorManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ��ȡ����
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		// ��ȡ���ߴ���������
		Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		// ע�ᴫ����	�����ڲ���
		sensorManager.registerListener(new SensorEventListener() {
			
			@Override
			// ����������֪�����Ļ����ı仯ʱ���ø÷���
			public void onSensorChanged(SensorEvent event) {
				// ���յ��¼�event��������һЩ���ݣ�
				// ����
				float acc = event.accuracy;
				// ����values����ĵ�0��ֵ������ǹ��ߵ�ǿ��
				float lux = event.values[0];
				
				Toast.makeText(MainActivity.this, "acc----->" + acc, Toast.LENGTH_LONG).show();
				System.out.println("acc----->" + acc);
				Toast.makeText(MainActivity.this, "lux----->" + lux, Toast.LENGTH_LONG).show();
				System.out.println("lux----->" + lux);
				
			}
			
			@Override
			// ���������ľ��ȳ��ֱ仯��ʱ��
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
			
		}, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
		
	}


}
