package com.xmrbi.rinoWeb.utils.socket.msgProc;

import com.google.common.collect.Queues;

import java.util.concurrent.LinkedBlockingQueue;

public class SocketMsgQueue {
	private static SocketMsgQueue instance = new SocketMsgQueue();
	private static LinkedBlockingQueue<String> msgQueue = Queues.newLinkedBlockingQueue();
	
	private SocketMsgQueue(){
	}
	
	public static SocketMsgQueue getInstance(){
		return instance;
	}
	
	public boolean put(String msg){
		return msgQueue.add(msg);
	}
	
	public String take() throws InterruptedException{
		return msgQueue.take();
	}
	
	public void clear(){
		msgQueue.clear();
	}
	
	public int size(){
		return msgQueue.size();
	}
}
