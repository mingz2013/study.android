package com.example.json01;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity {
	// 创建一个json数据对象
	private String jsonData = "[{\"name\":\"zhangsan\",\"age\":20},{\"name\":\"lisi\",\"age\":30}]";
	private Button button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button)findViewById(R.id.buttonId);
		button.setOnClickListener(new ButtonListener());
	}
	private class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			JsonUtils jsonUtils = new JsonUtils();
			jsonUtils.parseJson(jsonData);
		}
		
	}

}
