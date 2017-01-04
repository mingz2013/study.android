package com.example.sqlite.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/*
 * DatabaseHeper��Ϊһ������SQLite�������࣬�ṩ��������Ĺ���
 *��һ��getReadableDatabase(), getWritableDatabase() ���Ի��SQLiteDatabase����ͨ���ö�������ݿ���в���
 *�ڶ����ṩ��onCreate()��onUpdate() �����ص����������������ڴ������������ݿ�ʱ�������Լ��Ĳ���
 * */
public  class DatabaseHelper extends SQLiteOpenHelper{
	private static final int VERSION = 1;
	// ��SQLiteOpenHelper�����൱�У������иù��캯��
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		// ����ͨ��super���ø���Ĺ��캯��
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public DatabaseHelper(Context context, String name){
		this(context, name, VERSION);
	}
	public DatabaseHelper(Context context, String name, int version){
		this(context, name, null, version);
	}
	@Override// �ú������ڵ�һ�δ������ݿ�ʱִ�У�ʵ�����ǵ�һ�εõ�SQLiteDatabase�����ʱ��
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("create a database");
		// execSQL��������ִ��sql���
		db.execSQL("create table user(id int, name varchar(20))");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		System.out.println("update database");
	}
	
	
	

}
