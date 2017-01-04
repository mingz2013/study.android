package com.example.android_021_testmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        
    	int Group1 = 1;
    	menu.add(Group1,	// Group	// 组ID
    			1,			// item id 	// 菜单项ID
    			1,			// order 	// 排序ID
    			"item1"		// title	// 标题
    			);
    	menu.add(Group1, 2, 2, "item2");
    	
    	int Group2 = 2;
    	menu.add(Group2, 3, 3, "item1");
    	menu.add(Group2, 4, 4, "item2");
    	
    	return true;
    }
    
}
