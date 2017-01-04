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
		
		// Ҫ��ʾͼƬ·��,�ٶȵ���ҳ��ʶͼƬ--2013/04/21
		String urlStr = "http://www.baidu.com/img/420b_ead78e6081de7939cdf8eff9e608617f.gif";
		try {
			// ʵ����URL
			URL url = new URL(urlStr);
			// 1.ֱ��ʹ��URL���������
			//InputStream in = url.openStream();
			// 2.���URLconnection
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			// 3.�����HTTPЭ�����ʹ��HttpURLConnection
			//HttpURLConnection httpConn = (HttpURLConnection)conn;
			//in = httpConn.getInputStream();
			// ͨ��BitmapFactory�������Bitmapʵ��
			Bitmap bitmap = BitmapFactory.decodeStream(in);
			// ΪImageView����ͼƬ
			imageView.setImageBitmap(bitmap);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



}
