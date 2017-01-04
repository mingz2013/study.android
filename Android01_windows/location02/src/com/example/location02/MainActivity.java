package com.example.location02;

import java.util.Iterator;
import java.util.List;

import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button locationButton = null;
	private Button bestProviderButton = null;
	private LocationManager locationManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		locationButton = (Button)findViewById(R.id.locationButtonId);
		bestProviderButton = (Button)findViewById(R.id.bestProviderButtonId);
		
		locationButton.setOnClickListener(new LocationButtonListener());
		bestProviderButton.setOnClickListener(new BestProviderButtonListener());
		
		locationManager = (LocationManager)MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
		
	}
	private class LocationButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// 得到一个locationProvider对象组合
			List<String> providers = locationManager.getAllProviders();
			// 用迭代器打印所有的location provider
			for(@SuppressWarnings("rawtypes")
			Iterator iterator = providers.iterator(); iterator.hasNext();){
				String provider = (String)iterator.next();
				Toast.makeText(MainActivity.this, provider, Toast.LENGTH_LONG).show();
				System.out.println(provider);
			}
			
		}
		
	}
	private class BestProviderButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// 生成一个Criteria对象
			Criteria criteria = new Criteria();
			//设置查询条件
			// 高精度的
			criteria.setAccuracy(criteria.ACCURACY_FINE);
			// 电量消耗要低
			criteria.setPowerRequirement(criteria.POWER_LOW);
			// 不需要海拔
			criteria.setAltitudeRequired(false);
			// 不需要速度
			criteria.setSpeedRequired(false);
			// 不产生费用
			criteria.setCostAllowed(false);
			// 如果参数是true，只在打开的provider里面查找最佳的，如果为false，则在设备里所有的provider里面查找最佳的，不管是否开启
			String provider = locationManager.getBestProvider(criteria, false);
			System.out.println("best provider----->" + provider);
			Toast.makeText(MainActivity.this, "best provider----->" + provider, Toast.LENGTH_LONG).show();
			
		}
		
	}
	

}
