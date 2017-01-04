package com.example.android020;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.PixelFormat;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
	// 声明视频试图
	private VideoView videoView;
	// 声明媒体控制组件
	private MediaController control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 设置窗口特征
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        // 实例化file
        File video = new File("/sdcard/video.mp4");
        // 判断文件是否存在
        if(video.exists()){
        	videoView = (VideoView)findViewById(R.id.videoView);
        	videoView.setVideoPath(video.getAbsolutePath());
        	control = new MediaController(this);
        	
        	// 相互关联
        	control.setMediaPlayer(videoView);
        	videoView.setMediaController(control);
        	
        	// 获取焦点
        	videoView.requestFocus();
        }
        
        
    }


    
    
}
