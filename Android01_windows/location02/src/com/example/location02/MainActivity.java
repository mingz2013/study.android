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
			// �õ�һ��locationProvider�������
			List<String> providers = locationManager.getAllProviders();
			// �õ�������ӡ���е�location provider
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
			// ����һ��Criteria����
			Criteria criteria = new Criteria();
			//���ò�ѯ����
			// �߾��ȵ�
			criteria.setAccuracy(criteria.ACCURACY_FINE);
			// ��������Ҫ��
			criteria.setPowerRequirement(criteria.POWER_LOW);
			// ����Ҫ����
			criteria.setAltitudeRequired(false);
			// ����Ҫ�ٶ�
			criteria.setSpeedRequired(false);
			// ����������
			criteria.setCostAllowed(false);
			// ���������true��ֻ�ڴ򿪵�provider���������ѵģ����Ϊfalse�������豸�����е�provider���������ѵģ������Ƿ���
			String provider = locationManager.getBestProvider(criteria, false);
			System.out.println("best provider----->" + provider);
			Toast.makeText(MainActivity.this, "best provider----->" + provider, Toast.LENGTH_LONG).show();
			
		}
		
	}
	

}
