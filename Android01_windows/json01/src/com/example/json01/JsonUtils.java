package com.example.json01;

import java.io.StringReader;

import android.util.JsonReader;

public class JsonUtils {
	public void parseJson(String jsonData){
		try {
			// ������Ҫ�ڳ����������Ӧ��API���ܽ�������������������Ժ���ѧ��һ��
			// ��Ҫ����JSON���ݣ�����Ҫ����һ��JsonReader����
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
