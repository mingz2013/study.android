package com.example.json01;

import java.io.StringReader;

import android.util.JsonReader;

public class JsonUtils {
	public void parseJson(String jsonData){
		try {
			// 这里需要在程序中添加相应的API才能解决错误，这里先跳过，以后再学这一节
			// 需要解析JSON数据，首先要生成一个JsonReader对象
			JsonReader reader = new JsonReader(new StringReader(jsonData));
			reader.beginArray();
			while(reader.hasNext()){
				reader.beginObject();
				while(reader.hasNext()){
					String tagName = reader.nextName();
					if(tagName.equals("name")){
						System.out.println("name---->" + reader.nextString());
					}
					else if(tagName.equals("age")){
						System.out.println("age----->" + reader.nextInt());
					}
				}
				reader.endObject();
			}
			reader.endArray();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
