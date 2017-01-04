package com.mingzz.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 一个简单的服务器，它等待并监听远程联接请求
// 然后将服务请求委派给createService方法
public abstract class Server implements Runnable{
	// 服务器联接的默认端口
	public static final int DEFFAULT_PORT = 6666;
	// 服务器所分配的端口
	protected int port;
	// 监听服务请求的ServerSocket
	protected ServerSocket listener;
	// 服务器执行线程
	protected Thread exec;
	
	// 当异常发生时，返回一个错误信息并推出
	public static void fail(Exception e, String msg)
	{
		System.err.println(msg + ": " + e);
		System.exit(1);
	}
	// 用给定的端口号创建一个新的Server对象
	public Server(int portNo)
	{
		// 设置端口，确保它非零非负
		port = (portNo <= 0) ? DEFFAULT_PORT : portNo;
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail(e, "Exception occured while creating server socket");
		}
		exec = new Thread(this);
	}
	
	// 启动执行县城
	public final void start()
	{
		exec.start();
	}
	
	// 用指定的socket创建一个服务
	protected abstract void createService(Socket socket);
	
	// 服务器线程的主要工作部分，监听并接受客户端联接
	public void run()
	{
		System.out.println("Server: listening on port " + port);;
		System.out.println("Server: use Ctrl+c to terminate service");
		try {
			Thread thread = Thread.currentThread();
			while (exec == thread) {
				// 监听并接受联接
				Socket clientSocket = listener.accept();
				// 使用所接受的Socket创建服务
				createService(clientSocket);
				// 打印一个已连接消息到控制台
				System.out.println("\nConnected to " + clientSocket.getInetAddress() + " : " + clientSocket.getPort());
				try{
					Thread.sleep(25);
				}catch(InterruptedException e)
				{}
				
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			fail(e, "Exception while listening for connections");
		}
		
		
		
		
	}
	
	
}
