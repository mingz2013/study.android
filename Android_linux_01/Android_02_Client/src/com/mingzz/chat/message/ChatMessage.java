package com.mingzz.chat.message;

import java.io.Serializable;

public class ChatMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long fromID;
	public long toID;
	public String message;

}
