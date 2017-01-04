package com.mingzz.chat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.mingzz.chat.message.TransmissionData;
import com.mingzz.chat.message.UserMessage;



public class AbstractConnection {
	
	// 传送的对象
	protected TransmissionData transmissionData;
	// 终端通信socket
	protected Socket socket;
	
	// 输入输出留
	protected ObjectOutputStream oos;
	protected ObjectInputStream ois;
	protected AbstractConnection()
	{
		socket = null;
	}
	public AbstractConnection(Socket ClientSocket)
	{
		this.socket = ClientSocket;
	}
	// 打开联接
	protected boolean open()
	{
		try{
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		}catch(IOException e){
			e.printStackTrace();
			close(true);	// io错误，关闭socket
			return false;
		}
		return true;
	}
	// 尝试关闭socket
	protected void close(
			boolean ioError	// 如果是io错误则为真
			)
	{
		// 如果有错误发生，发送一个传送终止信号，
		// 这种操作应该关闭另一端的服务
		if(!ioError){
			send(MessageFactory.createTransmissionData(MessageFactory.TRANS_OF_END, null));
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void send(TransmissionData transmissionData)
	{
		// 只有在socket处于联接时才发送消息
		if(socket.isConnected())
		{
			
			
			try {
				
				oos.writeObject(transmissionData);
				oos.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("write Object wrong....");
				e.printStackTrace();
			}
			
		}else{
			System.err.println("Socket not connected....");
		}
	}
	// 从消息中解析消息头
	protected int parseTransmissionFlag()
	{
		if(transmissionData == null) return 0;
		return transmissionData.transmissionFlag;
	}
	// 解析消息部分
	protected UserMessage parseUserMessage()
	{
		if(transmissionData == null) return null;
		return transmissionData.userMessage;
	}
	// 尝试从输入留中接受信息
	protected void recv()
	{
		transmissionData = null;
		
			try {
				transmissionData = (TransmissionData)ois.readObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				close(true);
			}
		
	}
}

