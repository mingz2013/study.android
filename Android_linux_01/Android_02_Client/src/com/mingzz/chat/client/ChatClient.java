package com.mingzz.chat.client;

import java.net.Socket;

import com.mingzz.chat.AbstractConnection;
import com.mingzz.chat.MessageFactory;
import com.mingzz.chat.message.TransmissionData;
import com.mingzz.chat.message.UserMessage;


public abstract class ChatClient extends AbstractConnection implements Runnable{
	// 客户端执行线程
	private Thread exec;
	//private boolean isConnect = false;
	// 用指定的socket创建一个新的chatsocket
	public ChatClient(Socket s)
	{
		super(s);
		exec = new Thread(this);
	}
	public void start()
	{
		exec.start();
	}
	@SuppressWarnings("deprecation")
	public void stop(){
		close(false);
		//setConnect(false);
		exec.stop();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 打开联接
		if(!open())
		{
			//setConnect(false);
			System.out.println("Could not open connection.");
			return;
		}
		//setConnect(true);
		while(true)
		{
			recv();
			int transmissionFlag = parseTransmissionFlag();
			
			switch (transmissionFlag) {
			case MessageFactory.TRANS_OF_END:	
				close(false);
				//setConnect(false);
				break;
			case MessageFactory.TRANS_OF_USERMESSAGE:	
				doUserMessage(parseUserMessage());
				break;

			default:
				break;
			}
			
		}
	}
	
	protected abstract void doUserMessage(UserMessage userMessage);
	
	public void sendMessage(UserMessage userMessage){
		TransmissionData transmissionData = MessageFactory.createTransmissionData(MessageFactory.TRANS_OF_USERMESSAGE, userMessage);
		send(transmissionData);
	}
	/*
	public boolean isConnect() {
		return isConnect;
	}
	public void setConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}
	*/
	

}
