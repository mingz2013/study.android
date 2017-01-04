package com.example.location01;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button)findViewById(R.id.locationButtonId);
		button.setOnClickListener(new ButtonListener());
	}
	private class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// ����ת�ͣ��õ�LocationManager����
			LocationManager locationManager = (LocationManager)MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
			// ���嵱ǰ��ʹ�õ�location provider,���ζ�λ�������Сʱ�䣬�����ζ�λ�������С���룬�ͼ�����
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER	, 5000	, 1, new TestLocationListener());
			
		}
		
	}
	private class TestLocationListener implements LocationListener{

		@Override
		// ���豸��λ�÷����ı�ʱ
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			// �õ��û���ǰ�ľ��� �� γ��
			System.out.println(location.getLongitude());
			Toast.makeText(MainActivity.this, "����----->" + location.getLongitude(), Toast.LENGTH_LONG).show();
			System.out.println(location.getLatitude());
			Toast.makeText(MainActivity.this, "γ��----->" + location.getLatitude(), Toast.LENGTH_LONG).show();
			
		}

		@Override
		// 
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
	}

	

}
