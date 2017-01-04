package com.example.android_02_client;

import com.mingzz.chat.client.User;

import android.app.Application;

public class AppGlobal extends Application{
	private static User user = null;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		AppGlobal.user = user;
	}
}
