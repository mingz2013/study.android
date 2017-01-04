package com.example.t2_helloworld2;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;


public class MainActivity extends Activity {
	private Button button = null;
	private TextView textView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        textView = (TextView)findViewById(R.id.textview1);
        button.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			textView.setText("hello linux android");
			Toast.makeText(MainActivity.this, "helloworld android linux", Toast.LENGTH_LONG).show();
		}
    	
    }

		



    
}
