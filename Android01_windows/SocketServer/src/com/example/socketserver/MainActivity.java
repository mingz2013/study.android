package com.example.socketserver;


import java.net.DatagramPacket;
import java.net.DatagramSocket;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;


public class MainActivity extends Activity {
	private Button startButton = null; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton = (Button)findViewById(R.id.start);
		startButton.setOnClickListener(new StartButtonListener());
	}
	class StartButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new ServerThread().start();
		}
		
	}
	class ServerThread extends Thread{

		@Override
		/**
		 * TCP Server
		 * **/
	/*	public void run() {
			// 声明一个serverSocket对象
			ServerSocket serverSocket = null;
			try {
				// 创建一个serverSocket对象，并让这个socket在4567端口监听
				serverSocket = new ServerSocket(4567);
				// 调用accept()方法接收客户端发送的请求，返回一个连接socket，一个阻塞的方法
				Socket socket = serverSocket.accept();
				// 从Socket当中得到InputStream对象
				InputStream inputStream = socket.getInputStream();
				byte buffer[] = new byte[1024*4];
				int temp = 0;
				// 从InputStream当中读取客户端所发送的数据
				while ((temp = inputStream.read(buffer)) != -1) {
					System.out.println(new String(buffer, 0, temp));
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				try {
					serverSocket.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		
		
	}
	*/
		/**
		 * UDP Server
		 * **/
		public void run(){
			try {
				// 创建一个DatagramSocket对象，并监听指定的端口
				DatagramSocket socket = new DatagramSocket(4567);
				byte data[] = new byte[1024];
				// DatagramPacket对象是UDP发送的包，创建一个空的DatagramPacket对象
				DatagramPacket packet = new DatagramPacket(data, data.length);
				// 使用receive方法接收客户端所发送的数据，阻塞的方法
				socket.receive(packet);
				System.out.println(packet.getLength());
				String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
				System.out.println("result--->" + result);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
