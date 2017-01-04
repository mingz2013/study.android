package com.example.android01_getapicturefrominternet;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Bitmap;

public class MainActivity extends Activity {
	private EditText pathText;
	private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        pathText = (EditText)findViewById(R.id.path);
        imageView = (ImageView)findViewById(R.id.imageView);
    }
    
    public void showimage(View v){
    	String path = pathText.getText().toString();
    	try{
    	Bitmap bitmap = ImageService.getImage(path);
    	imageView.setImageBitmap(bitmap);
    	}catch(Exception e){
    		e.printStackTrace();
    		Toast.makeText(MainActivity.this, R.string.error, 1).show();
    	}
    }


   
    
}
