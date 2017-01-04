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
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
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
	
	/*
	 * 该函数返回整形 -1：代表下载文件出错。0：代表下载文件成功。1：代表文件已存在
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
	/**加两个*，变蓝了，可以产生文档
	 * 根据URL得到输入流
	 * **/
	public InputStream getInputStreamFromUrl(String urlStr) throws MalformedURLException, IOException {
		url = new URL(urlStr);
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
		InputStream inputStream = urlConn.getInputStream();
		return inputStream;
	}
}
