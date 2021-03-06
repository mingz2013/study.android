package com.mingzz.chat.server;

import java.net.Socket;


public class ChatServer extends Server{

	public ChatServer(int portNo) {
		super(portNo);
		// TODO Auto-generated constructor stub
	}

	

	@Override// 通过创建一个新的Chatserver对象
	// 实现Server的createService方法来和客户端通信
	protected void createService(Socket socket) {
		// TODO Auto-generated method stub
		new ChatService(socket).start();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 0;
		if(args.length > 1)
		{
			try{
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				System.err.println("Invalid port specification; using defalut port of " + DEFFAULT_PORT);
				port = DEFFAULT_PORT;
			}
		}else{
			//System.out.println("Usage:java ChatTest <hostname> [<port>]");
			//System.exit(0);
			System.err.println("Invalid port specification; using defalut port of " + DEFFAULT_PORT);
			port = DEFFAULT_PORT;
		}
		Server s = new ChatServer(port);
		s.start();
	}

}
