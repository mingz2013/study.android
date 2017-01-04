package com.example.sqlite.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
/*
 * DatabaseHeper作为一个访问SQLite的助手类，提供两个方面的功能
 *第一，getReadableDatabase(), getWritableDatabase() 可以获得SQLiteDatabase对象，通过该对象对数据库进行操作
 *第二，提供了onCreate()和onUpdate() 两个回调函数，允许我们在创建和升级数据库时，进行自己的操作
 * */
public  class DatabaseHelper extends SQLiteOpenHelper{
	private static final int VERSION = 1;
	// 在SQLiteOpenHelper的子类当中，必须有该构造函数
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		// 必须通过super调用父类的构造函数
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public DatabaseHelper(Context context, String name){
		this(context, name, VERSION);
	}
	public DatabaseHelper(Context context, String name, int version){
		this(context, name, null, version);
	}
	@Override// 该函数是在第一次创建数据库时执行，实际上是第一次得到SQLiteDatabase对象的时候
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("create a database");
		// execSQL函数用于执行sql语句
		db.execSQL("create table user(id int, name varchar(20))");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		System.out.println("update database");
	}
	
	
	

}
