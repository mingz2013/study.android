package com.example.android_028_progressdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mButton01, mButton02;
	int m_count = 0;
	// 声明进度条对话框
	ProgressDialog m_pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton01 = (Button)findViewById(R.id.button1);
        mButton02 = (Button)findViewById(R.id.button2);
        mButton01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				// 创建ProgressDialog对象
				m_pDialog = new ProgressDialog(MainActivity.this);
				// 设置进度条风格为 圆形 旋转的
				m_pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				// 设置ProgressDialog标题
				m_pDialog.setTitle("温馨提示");
				// 设置提示信息
				m_pDialog.setMessage("这是圆形进度条对话框");
				// 设置ProgressDialog标题图标
				m_pDialog.setIcon(R.drawable.ic_launcher);
				// 设置ProgressDialog的进度条是否不明确
				m_pDialog.setIndeterminate(false);
				// 设置是否可以按退回按键取消
				m_pDialog.setCancelable(true);
				// 设置ProgressDialog的一个Button
				m_pDialog.setButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						// 单击确定按钮取消对话框
						arg0.cancel();
					}
				});
				
				m_pDialog.show();
			}
		});
        mButton02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				m_count = 0;
				// 创建ProgressDialog对象
				m_pDialog = new ProgressDialog(MainActivity.this);
				// 设置进度条风格为 方形
				m_pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				// 设置ProgressDialog标题
				m_pDialog.setTitle("温馨提示");
				// 设置提示信息
				m_pDialog.setMessage("这是长形进度条对话框");
				// 设置ProgressDialog标题图标
				m_pDialog.setIcon(R.drawable.ic_launcher);
				// 设置 进度条进度
				m_pDialog.setProgress(100);
				// 设置ProgressDialog的进度条是否不明确
				m_pDialog.setIndeterminate(false);
				// 设置是否可以按退回按键取消
				m_pDialog.setCancelable(true);
				
				
				m_pDialog.show();
				
				
				new Thread(){
					public void run(){
						try {
							while (m_count <= 100) {
								// 由线程来控制进度
								m_pDialog.setProgress(m_count++);
								Thread.sleep(100);
							}
							m_pDialog.cancel();
							
						} catch (InterruptedException e) {
							// TODO: handle exception
							m_pDialog.cancel();
						}
					}
				}.start();
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
