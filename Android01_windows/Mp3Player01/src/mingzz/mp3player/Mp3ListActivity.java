package mingzz.mp3player;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import mingzz.download.HttpDownloader;
import mingzz.model.Mp3Info;
import mingzz.xml.Mp3ListContentHandler;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;

public class Mp3ListActivity extends ListActivity {
	private static final int UPDATE = 1;
	private static final int ABOUT = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mp3_list);
	}
	/**
	 *  在用户点击Menu按钮之后，会调用该方法，我们可以在这个方法当中加入自己的按钮控件
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// 增加两个按钮
		menu.add(0, UPDATE, 1, R.string.mp3list_update);
		menu.add(0, ABOUT, 2, R.string.mp3list_about);
		return super.onCreateOptionsMenu(menu);
	}
	/**
	 * 当用户点击子菜单时调用此方法
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.out.println("itemId---->" + item);
		if(item.getItemId() == UPDATE){
			// 用户点击了更新列表按钮
			String xml = downloadXML("http://10.0.2.2/test/mp3/resources.xml");
			System.out.println("xml----->" + xml);
			parse(xml);
		}
		else if(item.getItemId() == ABOUT){
			// 用户点击了关于按钮
		}
		return super.onOptionsItemSelected(item);
	}
	private String downloadXML(String urlStr){
		HttpDownloader httpDownloader = new HttpDownloader();
		String result = httpDownloader.download(urlStr);
		return result;
	}
	private List<Mp3Info> parse(String xmlStr){
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		List<Mp3Info> infos = new ArrayList<Mp3Info>();
		try {
			XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
			Mp3ListContentHandler mp3ListContentHandler = new Mp3ListContentHandler(infos);
			xmlReader.setContentHandler(mp3ListContentHandler);
			xmlReader.parse(new InputSource(new StringReader(xmlStr)));
			for (Iterator iterator = infos.iterator(); iterator.hasNext();) {
				Mp3Info mp3Info = (Mp3Info)iterator.next();
				System.out.println(mp3Info);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return infos;
	}


}
