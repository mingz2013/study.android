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
		// ΪRadioGroup���ü���������Ҫע����ǣ�����ļ�������button������������ͬ
		genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(femaleButton.getId() == checkedId)
				{
					System.out.println("female");
					// Toast Ӧ�ã���ʾ��Ϣ-----------����������ûЧ������
					Toast.makeText(MainActivity.this, "female", Toast.LENGTH_SHORT).show();
				}
				else if(maleButton.getId() == checkedId)
				{
					System.out.println("male");
				}
			}
		});
		// Ϊ��ѡ��ť���ü�����
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
