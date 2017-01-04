package com.example.sqlite;

import com.example.sqlite.db.DatabaseHelper;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class MainActivity extends Activity {

	private Button createDataBase = null;
	private Button updateDatabase = null;
	private Button insert = null;
	private Button update = null;
	private Button query = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createDataBase = (Button)findViewById(R.id.creatadatebase);
		updateDatabase = (Button)findViewById(R.id.updatedatabase);
		insert = (Button)findViewById(R.id.insert);
		update = (Button)findViewById(R.id.update);
		query = (Button)findViewById(R.id.query);
		createDataBase.setOnClickListener(new CreateDateBaseButtonListener());
		updateDatabase.setOnClickListener(new UpdateDataBaseButtonListener());
		insert.setOnClickListener(new InsertButtonListener());
		update.setOnClickListener(new UpdateButtonListener());
		query.setOnClickListener(new QueryButtonListener());
	}
	class CreateDateBaseButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// ����һ��databasehelper����
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this, "test.db");
			//
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			
		}
		
	}
	class UpdateDataBaseButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// ����һ��databasehelper����
						DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this, "test.db", 2);
						//
						SQLiteDatabase db = dbHelper.getReadableDatabase();
			
		}
		
	}
	class InsertButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// ����ContentValues����
			ContentValues values = new ContentValues();
			// ��ö����в����ֵ�ԣ����м���������ֵ��ϣ�����뵽��һ�е�ֵ��ֵ������е�����������ƥ��
			values.put("id", 1);
			values.put("name", "zhangsan");
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this, "test_db");
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			// ����insert�������Ϳ��Խ����ݲ��뵽���ݿ���
			db.insert("user", null, values);
		}
		
	}
	// ���²������൱��ִ��sql��䵱�е� update
	class UpdateButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this, "test_db");
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", "zhangsanfeng");
			db.update("user", values, "id=?", new String[]{"1"});
		}
		
	}
	class QueryButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this, "test_db");
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			Cursor cursor = db.query("user", new String[]{"id, name"}, "id=?", new String[]{"1"}, null, null, null);
			while (cursor.moveToNext()) {
				String name = cursor.getString(cursor.getColumnIndex("name"));
				System.out.println("query----->" + name);
			}
		}
		
	}



}
