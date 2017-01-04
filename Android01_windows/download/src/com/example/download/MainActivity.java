package com.example.download;

import com.example.utils.HttpDownloader;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;


public class MainActivity extends Activity {

	private Button downloadTextButton = null;
	private Button downloadmp3Button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		downloadTextButton = (Button)findViewById(R.id.downloadtextbutton);
		downloadmp3Button = (Button)findViewById(R.id.downloadmp3button);
		downloadTextButton.setOnClickListener(new DownloadTextButtonListener());
		downloadmp3Button.setOnClickListener(new DownloadMp3ButtonListener());
		
	}
	class DownloadTextButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			HttpDownloader httpDownloader = new HttpDownloader();
			String lrc = httpDownloader.download("http://10.0.2.2/test/1.lrc");
			System.out.println(lrc);
		}
		
	}
	class DownloadMp3ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			HttpDownloader httpDownloader = new HttpDownloader();
			int result = httpDownloader.downFile("http://10.0.2.2/test/1.mp3", "voa/", "Mp3.mp3");
			System.out.println(result);
		}
		
	}

}
