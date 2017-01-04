package com.example.location05;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button geocodingButton = null;
	private Button reverseButton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		geocodingButton = (Button)findViewById(R.id.geocodingbuttonId);
		geocodingButton.setOnClickListener(new GeocodingButtonListener());
		
		reverseButton = (Button)findViewById(R.id.reversebuttonId);
		reverseButton.setOnClickListener(new ReverseButtonListener());
	}
	private class GeocodingButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new GeocodingTask().execute(null);
			
		}
		
	}
	private class ReverseButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new ReverseGeocodingTask().execute(null);
			
		}
		
	}
	// Òì²½²Ù×÷
	private class GeocodingTask extends AsyncTask<Integer, Integer, Integer>{

		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			try {
				Geocoder geocoder = new Geocoder(MainActivity.this);
				List<Address> addresses = geocoder.getFromLocationName("SFO", 1);
				System.out.println(addresses.size());
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return null;
		}
		
	}
	private class ReverseGeocodingTask extends AsyncTask<Integer, Integer, Integer>{

		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			
			try {
				Geocoder geocoder = new Geocoder(MainActivity.this, Locale.US);
				List<Address> addresses = geocoder.getFromLocation(40.714224, -73.961452, 1);
				for(@SuppressWarnings("rawtypes")
				Iterator iterator = addresses.iterator(); iterator.hasNext();){
					Address address = (Address)iterator.next();
					System.out.println(address);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}
	

}
