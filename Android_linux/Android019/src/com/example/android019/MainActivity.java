package com.example.android019;

import java.io.IOException;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button button01 ;
	Button button04;
	MediaPlayer mp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 实例化mediaplayer，从源文件中
        mp = MediaPlayer.create(this, R.raw.sounds);
         
        /*/ 从文件系统中
        try{
        mp = new MediaPlayer();
        String path = "/sdcard/test.pm3";
		mp.setDataSource(path);
		mp.prepare();
        }catch(Exception e){
        	
        }
        */
        
        /*/ 从网络中
        String path = "http://www.baidu.com/test.pm3";
        Uri uri = Uri.parse(path);
        mp = MediaPlayer.create(this, uri);
        
        */
        
	
        
        button01 = (Button)findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mp.start();
			}
		});
        
        button04 = (Button)findViewById(R.id.button04);
        button04.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.stop();		
			}
		});
    }


   
    
}
