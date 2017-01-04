package com.example.android03_xml_parser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class SAXForHandler extends DefaultHandler{
	private static final String TAG = "SAXForHandler";
	private List<Person> persons;
	private String perTag;	// 通过此变量，记录前一个标签的名称
	Person person;// 记录当前Person
	public List<Person> getPersons() {
		return persons;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		String data = new String(ch, start, length).trim();
		if(!"".equals(data.trim())){
			Log.i(TAG, "content: " + data.trim());
		}
		if("name".equals(perTag)){
			person.setName(data);
		}else if("age".equals(perTag)){
			person.setAge(new Short(data));
		}
		
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		Log.i(TAG, "endDocument()...");
		
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		Log.i(TAG, qName + "endElement()...");
		if("person".equals(localName)){
			persons.add(person);
			person = null;
		}
		perTag = null;
	}
	@Override // 适合在此时间中触发初始化行为
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		persons = new ArrayList<Person>();
		Log.i(TAG, "startDocument...");
		
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if("person".equals(localName)){
			for (int i = 0; i < attributes.getLength(); i++) {
				Log.i(TAG, "attributeName:" + attributes.getLocalName(i) + "_attribute_Value:" + attributes.getValue(i));
				person = new Person();
				person.setId(Integer.valueOf(attributes.getValue(i)));
			}
		}
		perTag = localName;
		Log.i(TAG, qName + "startElement()....");
	}
	
	
	
	
	
}
