package mingzz.download;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpDownloader {
	private URL url = null;
	/*
	 * 根据URL下载文件，文件是文本文件，函数的返回值是文件当中的文本
	 * 创建一个URL对象
	 * 通过URL对象创建一个HttpConnection对象
	 * 得到Inputstream
	 * 从Inputstream当中读取数据
	 * */
	public String download(String urlStr){
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader buffer = null;
		try{
			// 创建一个URL对象
			url = new URL(urlStr);
			// 创建一个Http连接
			//HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
			URLConnection urlConn = url.openConnection();
			urlConn.connect();
			// 使用IO流读取数据
			buffer = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while((line = buffer.readLine()) != null){
				sb.append(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				buffer.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
