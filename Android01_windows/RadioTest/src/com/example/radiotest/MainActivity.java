package com.example.radiotest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RadioGroup genderGroup = null;
	private RadioButton femaleButton = null;
	private RadioButton maleButton = null;
	private CheckBox swimBox = null;
	private CheckBox runBox = null;
	private CheckBox readBox = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		genderGroup = (RadioGroup)findViewById(R.id.genderGroup);
		femaleButton = (RadioButton)findViewById(R.id.femaleButton);
		maleButton = (RadioButton)findViewById(R.id.maleButton);
		swimBox = (CheckBox)findViewById(R.id.swim);
		runBox = (CheckBox)findViewById(R.id.run);
		readBox = (CheckBox)findViewById(R.id.read);
		// 为RadioGroup设置监听器，需要注意的是，这里的监听器和button监听器有所不同
		genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(femaleButton.getId() == checkedId)
				{
					System.out.println("female");
					// Toast 应用，提示信息-----------？？？？？没效果？？
					Toast.makeText(MainActivity.this, "female", Toast.LENGTH_SHORT).show();
				}
				else if(maleButton.getId() == checkedId)
				{
					System.out.println("male");
				}
			}
		});
		// 为多选按钮设置监听器
		swimBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					System.out.println("swim is Checked ");
				}
				else
				{
					System.out.println("swim is unchecked");
				}
			}
		});
		runBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
				{
					System.out.println("run is Checked ");
				}
				else
				{
					System.out.println("run is unchecked");
				}
			}
		});
		
	}



}
