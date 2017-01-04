package com.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyContentHandler extends DefaultHandler{
	String hisname, address, money, sex, status;
	String tagName;
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(tagName.equals("name"))
			hisname = new String(ch, start, length);
		else if(tagName.equals("sex"))
			sex = new String(ch, start, length);
		else if(tagName.equals("status"))
			status = new String(ch, start, length);
		else if(tagName.equals("address"))
			address = new String(ch, start, length);
		else if(tagName.equals("money"))
			money = new String(ch, start, length);
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("----begin-----");
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(localName.equals("worker")){
			this.printout();
		}
	}
	@Override
	public void startDocument() throws SAXException {
		System.out.println("----begin-----");
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("qname----------->" + qName);
		tagName = localName;
		if(localName.equals("worker")){
			for(int i = 0; i < attributes.getLength(); i++){
				System.out.println(attributes.getLocalName(i) + "-" + attributes.getValue(i));
			}
		}
	}
	private void printout(){
		System.out.print("name:");
		System.out.println(hisname);
		System.out.print("sex:");
		System.out.println(sex);
		
	}
	

}
