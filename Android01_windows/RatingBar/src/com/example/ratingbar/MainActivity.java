package com.example.ratingbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	private RatingBar ratingBar = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ratingBar = (RatingBar)findViewById(R.id.ratingbarId);
		ratingBar.setOnRatingBarChangeListener(new RatingBarListener());
		
	}
	private class RatingBarListener implements RatingBar.OnRatingBarChangeListener{

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			// TODO Auto-generated method stub
			System.out.println("rating--->" + rating);
			
		}
		
	}


}
