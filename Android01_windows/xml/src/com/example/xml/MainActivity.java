package com.example.xml;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.example.utils.HttpDownloader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button parseButton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		parseButton = (Button)findViewById(R.id.parse);
		parseButton.setOnClickListener(new parseButtonListener());
	}
	class parseButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			HttpDownloader hd = new HttpDownloader();
			String resultStr = hd.download("http://10.92.5.114:80/test/xml.xml");
			System.out.println(resultStr);
			try {
				// 创建一个SAXParserFactory
				SAXParserFactory factory = SAXParserFactory.newInstance();
				XMLReader reader = factory.newSAXParser().getXMLReader();
				// 为XMLreader设置内容处理器
				reader.setContentHandler(new MyContentHandler()); 
				// 开始解析文件
				reader.parse(new InputSource(new StringReader(resultStr)));	
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}

	

}
