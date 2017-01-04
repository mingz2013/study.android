package com.example.sensor01;

import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button = null;
	// 首先定义一个SensorManager对象，用于管理手机中的所有传感器
	private SensorManager sensorManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button)findViewById(R.id.sensorButtonId);
		button.setOnClickListener(new ButtonListener());
		// 得到sensorManager对象，通过服务的名字得到对应的服务对象
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
	}
	private class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// 获取list对象，里面是相应类型的传感器，这里是所有的传感器
			List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
			for(Sensor sensor:sensors){
				// 遍历，获取名字
				System.out.println(sensor.getName());
				Toast.makeText(MainActivity.this, sensor.getName(), Toast.LENGTH_LONG).show();
			}
			// 得到某一个传感器  ,得到默认的光线传感器
			Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
			System.out.println(sensor.getName());
		}
		
	}
}
