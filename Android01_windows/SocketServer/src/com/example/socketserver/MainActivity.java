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
			// ����һ��serverSocket����
			ServerSocket serverSocket = null;
			try {
				// ����һ��serverSocket���󣬲������socket��4567�˿ڼ���
				serverSocket = new ServerSocket(4567);
				// ����accept()�������տͻ��˷��͵����󣬷���һ������socket��һ�������ķ���
				Socket socket = serverSocket.accept();
				// ��Socket���еõ�InputStream����
				InputStream inputStream = socket.getInputStream();
				byte buffer[] = new byte[1024*4];
				int temp = 0;
				// ��InputStream���ж�ȡ�ͻ��������͵�����
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
				// ����һ��DatagramSocket���󣬲�����ָ���Ķ˿�
				DatagramSocket socket = new DatagramSocket(4567);
				byte data[] = new byte[1024];
				// DatagramPacket������UDP���͵İ�������һ���յ�DatagramPacket����
				DatagramPacket packet = new DatagramPacket(data, data.length);
				// ʹ��receive�������տͻ��������͵����ݣ������ķ���
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
