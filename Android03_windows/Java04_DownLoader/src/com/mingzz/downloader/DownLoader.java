package com.mingzz.downloader;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoader {
	String filename ;
	String path ;
	int threadsize ;		// 线程数
	
	public DownLoader(String filename, String urlpath, int threadsize){
		this.filename = filename;
		this.path = urlpath;
		this.threadsize = threadsize;
	}
	
	public void download() throws Exception{
		URL url = new URL(path);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setConnectTimeout(5 * 1000);
		connection.setRequestMethod("GET");
		
		int filelength = connection.getContentLength();	// 获取下载文件长度
		System.out.println("file length : " + filelength);
		
		RandomAccessFile file = new RandomAccessFile(filename, "rw");
		file.setLength(filelength);		// 设置本地文件长度
		file.close();
		connection.disconnect();
		
		
		int threadlength = filelength % threadsize == 0 ? filelength / threadsize : filelength / threadsize + 1;// 每条线城下载的长度
		
		for(int i = 0; i < threadsize; i++ ){
			int startposition = i * threadlength; // 计算每条线城应该从什么位置开始下载
			RandomAccessFile threadfile = new RandomAccessFile(filename, "rw");
			threadfile.seek(startposition);		// 从文件的什么位置开始写入数据
			// 启动所有线程 分别从 不同位置 下载文件
			new DownLoadThread(i, path, startposition, threadfile, threadlength).start();
		}
		
		int quit = System.in.read();
		while('q' != quit){
			Thread.sleep(2 * 1000);
		}
		
		
	}
	
	private class DownLoadThread extends Thread{
		private int threadId;
		private int startposition;
		private RandomAccessFile threadfile;
		private int threadlength;
		private String path;
		
		public DownLoadThread(int threadId, String path, int startposition, RandomAccessFile threadfile, int threadlength){
			this.threadId = threadId;
			this.startposition = startposition;
			this.threadfile = threadfile;
			this.threadlength = threadlength;
			this.path = path;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				URL url = new URL(path);
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.setConnectTimeout(5 * 1000);
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Range", "bytes=" + startposition + "-"); // 指定从文件什么位置开始下载
				InputStream inputStream = connection.getInputStream();
				byte[] buffer = new byte[1024];
				int len = -1;
				int length = 0;
				while(length < threadlength && (len = inputStream.read(buffer)) != -1){
					threadfile.write(buffer, 0, len);
					length += len;	// 累计下载长度
				}
				
				threadfile.close();
				inputStream.close();
				System.out.println("线程" + (threadId + 1) + "已经下载完成");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("线程" + (threadId + 1) + "下载出错" + e);
			}
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new DownLoader("000.zip", "http://localhost/phptest/000.zip", 5).download();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("出错。。。。。。。。。");
		}
	}

}
