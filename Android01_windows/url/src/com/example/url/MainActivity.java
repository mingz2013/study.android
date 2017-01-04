package com.example.url;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView)findViewById(R.id.imageView);
		
		// 要显示图片路径,百度的首页标识图片--2013/04/21
		String urlStr = "http://www.baidu.com/img/420b_ead78e6081de7939cdf8eff9e608617f.gif";
		try {
			// 实例化URL
			URL url = new URL(urlStr);
			// 1.直接使用URL获得输入流
			//InputStream in = url.openStream();
			// 2.获得URLconnection
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			// 3.如果是HTTP协议可以使用HttpURLConnection
			//HttpURLConnection httpConn = (HttpURLConnection)conn;
			//in = httpConn.getInputStream();
			// 通过BitmapFactory类解码获得Bitmap实例
			Bitmap bitmap = BitmapFactory.decodeStream(in);
			// 为ImageView设置图片
			imageView.setImageBitmap(bitmap);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



}
