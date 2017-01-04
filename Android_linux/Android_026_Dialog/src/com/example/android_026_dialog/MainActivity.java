package com.example.android_026_dialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	public static final int DIALOG1	= 1;
	public static final int DIALOG2	= 2;
	public static final int DIALOG3	= 3;
	public static final int DIALOG4	= 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_show1:
			showDialog(DIALOG1);
			break;
		case R.id.action_show2:
			showDialog(DIALOG2);
			break;
		case R.id.action_show3:
			showDialog(DIALOG3);
			break;
		case R.id.action_show4:
			showDialog(DIALOG4);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case DIALOG1:
			return buildDialog1(MainActivity.this);
		
		case DIALOG2:
			return buildDialog2(MainActivity.this);
			
		case DIALOG3:
			return buildDialog3(MainActivity.this);
	
		case DIALOG4:
			return buildDialog4(MainActivity.this);
			

		default:
			break;
		}
		return null;
	}
	private Dialog buildDialog1(Context context)
	{
		// 创建一个AlertDialog.Builder builder对象
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		// 给AlertDialog预设一个图片
		builder.setIcon(R.drawable.ic_launcher);
		// 给AlertDialog预设一个标题
		builder.setTitle("this is title");
		// 设置按钮的属性
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				setTitle("你点击了对话框的确定按钮");
			}
		});
		builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				setTitle("你点击了对话框上的取消按钮");
			}
		});
		return builder.create();
	}
	private Dialog buildDialog2(Context context){
		// 创建一个AlertDialog.Builder builder对象
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				// 给AlertDialog预设一个图片
				builder.setIcon(R.drawable.ic_launcher);
				// 给AlertDialog预设一个标题
				builder.setTitle("this is title");
				builder.setMessage("message message message message");
				// 设置按钮的属性
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						setTitle("你点击了对话框的确定按钮");
					}
				});
				builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						setTitle("你点击了对话框上的取消按钮");
					}
				});
				builder.setNeutralButton("more", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						setTitle("你点击了对话框的进入详细按钮");
					}
				});
				return builder.create();
	}
	
	private Dialog buildDialog3(Context context){
		LayoutInflater inflater = LayoutInflater.from(this);
		final View textEntryView = inflater.inflate(R.layout.alert_dialog_text_entry, null);
		// 创建一个AlertDialog.Builder builder对象
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		// 给AlertDialog预设一个图片
		builder.setIcon(R.drawable.ic_launcher);
		// 给AlertDialog预设一个标题
		builder.setTitle("this is title");
		builder.setView(textEntryView);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				setTitle("你点击了对话框的确定按钮");
			}
		});
		builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				setTitle("你点击了对话框上的取消按钮");
			}
		});
		return builder.create();
	}
	
	private Dialog buildDialog4(Context context){
		ProgressDialog dialog = new ProgressDialog(context);
		dialog.setTitle("正在处理中。。。");
		dialog.setMessage("等待。。");
		return dialog;
	}
    
}
