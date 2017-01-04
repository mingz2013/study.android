package com.example.zhaojm.a02_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by zhaojm on 15/12/14.
 */
public class FirstActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);  // 设置layout

        Button button1 = (Button)findViewById(R.id.button_1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "You clicked button_1", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class); // 显示Intent
                Intent intent = new Intent("com.example.zhaojm.a02_activity.ACTION_START"); // 隐式Intent
                intent.addCategory("com.example.zhaojm.a02_activity.MY_CATEGORY");


                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "add item menu item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "remove item menu item", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
