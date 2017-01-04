package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.auth.MalformedChallengeException;



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
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
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
	
	/*
	 * �ú����������� -1�����������ļ�����0�����������ļ��ɹ���1�������ļ��Ѵ���
	 * */
	public int downFile(String urlStr, String path, String fileName){
		InputStream inputStream = null;
		try {
			FileUtils fileUtils = new FileUtils();
			if (fileUtils.isFileExist(path + fileName)) {
				return 1;
			}else{
				inputStream = getInputStreamFromUrl(urlStr);
				File resultFile = fileUtils.write2SDFromInput(path, fileName, inputStream);
				if(resultFile == null){
					return -1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}finally{
			try {
				inputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return 0;
	}
	/**������*�������ˣ����Բ����ĵ�
	 * ����URL�õ�������
	 * **/
	public InputStream getInputStreamFromUrl(String urlStr) throws MalformedURLException, IOException {
		url = new URL(urlStr);
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
		InputStream inputStream = urlConn.getInputStream();
		return inputStream;
	}
}
