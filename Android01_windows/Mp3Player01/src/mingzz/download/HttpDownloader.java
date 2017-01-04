package mingzz.download;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpDownloader {
	private URL url = null;
	/*
	 * ����URL�����ļ����ļ����ı��ļ��������ķ���ֵ���ļ����е��ı�
	 * ����һ��URL����
	 * ͨ��URL���󴴽�һ��HttpConnection����
	 * �õ�Inputstream
	 * ��Inputstream���ж�ȡ����
	 * */
	public String download(String urlStr){
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader buffer = null;
		try{
			// ����һ��URL����
			url = new URL(urlStr);
			// ����һ��Http����
			//HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
			URLConnection urlConn = url.openConnection();
			urlConn.connect();
			// ʹ��IO����ȡ����
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
