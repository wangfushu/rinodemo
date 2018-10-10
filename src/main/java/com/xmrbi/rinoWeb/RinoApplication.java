package com.xmrbi.rinoWeb;

import com.xmrbi.rinoWeb.common.MessageConfigConstant;
import com.xmrbi.rinoWeb.utils.socket.SocketServerNettyMain;
import com.xmrbi.rinoWeb.utils.socket.msgProc.SocketMsgQueuePolling;
import com.xmrbi.rinoWeb.utils.webSocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RinoApplication  implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(RinoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RinoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SocketMsgQueuePolling msgPolling = new SocketMsgQueuePolling();
		Thread msgPollingThread = new Thread(msgPolling);
		msgPollingThread.start();

		SocketServerNettyMain.getinstance(MessageConfigConstant.socket_server_port).init();

		WebSocketServer.getInstance(MessageConfigConstant.websocket_server_port).init();

		/* 加载公共代码缓存 */
		//xwsCache.loadCache();

		logger.info("SOCKET RUN ......");
		//tpmCache.startSocketServer();
		logger.info("===========================================================================================================================");



	/*	int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 8989;
		}
		new DiscardServer(port).run();
		WebSocketServer.getInstance(port).init();


		System.out.println("server:run()");*/
	}
}
