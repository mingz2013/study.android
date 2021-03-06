package com.example.android02_webcodeviewer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamTool {
	public static byte[] read(InputStream inputStream) throws IOException{
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buffer)) != -1) {
			arrayOutputStream.write(buffer, 0, len);
		}
		inputStream.close();
		return arrayOutputStream.toByteArray();
	}
}
