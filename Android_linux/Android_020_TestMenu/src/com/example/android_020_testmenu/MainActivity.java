package com.example.android_020_testmenu;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final int RED_MENU_ID = Menu.FIRST;
	public static final int GREEN_MENU_ID = Menu.FIRST + 1;
	public static final int BLUE_MENU_ID = Menu.FIRST + 2;
	private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView_helloworld);
    }


    @Override	// 建立菜单时进行设置，为每一个按钮设置ID
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
    	super.onCreateOptionsMenu(menu);
    	menu.add(0, RED_MENU_ID, 0, "red");
    	menu.add(0, GREEN_MENU_ID, 1, "green");
    	menu.add(0, BLUE_MENU_ID, 2, "blue");
    	
        return true;
    }


	@Override	// 菜单被选择时调用
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case RED_MENU_ID:
			textView.setBackgroundColor(Color.RED);
			break;
		case GREEN_MENU_ID:
			textView.setBackgroundColor(Color.GREEN);
			break;
		case BLUE_MENU_ID:
			textView.setBackgroundColor(Color.BLUE);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
    
}
