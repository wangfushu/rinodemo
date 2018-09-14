package com.xmrbi.rinoWeb.utils.socket.msgProc;


import com.xmrbi.rinoWeb.utils.webSocket.WebSocketServerHandler;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketMsgQueuePolling implements Runnable {

	static Logger logger = LoggerFactory.getLogger(SocketMsgQueuePolling.class);
	
	private static SocketMsgQueue msgQueue = SocketMsgQueue.getInstance();
	
	boolean bRunning = true;
	
	@Override
	public void run() {
		while(bRunning){
			try {
				logger.info("Polling......");
				String msg = msgQueue.take();
				if(msg == null || msg.isEmpty()){
					Thread.sleep(0);
					continue;
				}
				
				ChannelGroup channels = WebSocketServerHandler.getChannelGroup();
				if(channels == null || channels.size() == 0){
					Thread.sleep(0);
					continue;
				}
				
				String notiJsonStr = ClientNotiMsgConverter.getInstance().msgConvert(msg);
//				logger.debug("[Socket Msg Queue] ( Message Send ) {}", notiJsonStr);
				for(Channel channel : channels){
					synchronized (channel) {
		    			channel.write(new TextWebSocketFrame(notiJsonStr));
		    			channel.flush();
					}
				}
				Thread.sleep(0);
			} catch (InterruptedException e) {
				//logger.error(e.getMessage(),e);
				logger.error(e.getMessage(),e);
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public void stop(){
		bRunning = false;
	}
	
}
