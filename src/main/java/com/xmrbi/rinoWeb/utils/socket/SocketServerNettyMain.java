package com.xmrbi.rinoWeb.utils.socket;


import com.xmrbi.rinoWeb.utils.socket.codec.ServerMessageDecoder;
import com.xmrbi.rinoWeb.utils.socket.codec.ServerMessageEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;

public class SocketServerNettyMain {
	static Logger logger = LoggerFactory.getLogger(SocketServerNettyMain.class);
	private static SocketServerNettyMain instance = null;
	private int serverPort = 0;
	private ServerBootstrap serverBootstrap = null;
	private EventLoopGroup bossGroup = null; 
	private EventLoopGroup workerGroup = null;

	public static SocketServerNettyMain getinstance(String serverPortStr) {
		return getinstance(Integer.parseInt(serverPortStr));
	}
	public static SocketServerNettyMain getinstance(int serverPort) {
		synchronized (SocketServerNettyMain.class) {
			if (instance == null) {
				instance = new SocketServerNettyMain(serverPort);
			}
			return instance;
		}
	}
	
	public SocketServerNettyMain() {
	}

	public SocketServerNettyMain(int serverPort) {
		this.serverPort = serverPort;
	}

	public void init() {
		// NioEventLoopGroup 는 멀티 쓰레드 이벤트 루프
		// bossGroup는 들어오는 연결을 수락
		// workerGroup는 연결의 트레픽 처리
		bossGroup = new NioEventLoopGroup(); 
		workerGroup = new NioEventLoopGroup();
		try {
			// ServerBootstrap는 서버설정 도우미 클래스
			serverBootstrap = new ServerBootstrap(); 
			serverBootstrap.group(bossGroup, workerGroup)
			// NioServerSocketChannel클래스를 이용하여 새로운 채널 생성 (인스턴스화)
					.channel(NioServerSocketChannel.class) 
					.childHandler(new ChannelInitializer<SocketChannel>() {
								@Override
								public void initChannel(SocketChannel ch)throws IllegalArgumentException {
									ChannelPipeline channelPipeline = ch.pipeline();
									channelPipeline.addLast("encoder", new ServerMessageEncoder() )
													.addLast("decoder", new ServerMessageDecoder() )
													.addLast("handler", new SocketServerNettyHandler());
								}
							}).option(ChannelOption.SO_BACKLOG, 128) // worker thread 최대 겟수 
					.childOption(ChannelOption.SO_KEEPALIVE, true); // 연결 유지 셋팅

			// 바인딩 해서 들어오는 연결을 수락
			ChannelFuture fText = serverBootstrap.bind(this.serverPort).sync(); // 서버 시작
			
			logger.debug("[{}] fText", fText.toString());
			logger.info("[ {} ] Socket Server Bind", this.serverPort);
			
		} catch (InterruptedException e) {
			// 소켓 바인드 에러
			logger.trace("SOCKET BIND ERROR [{}]", serverPort);
			logger.error(e.getMessage(),e);
			Thread.currentThread().interrupt();
			System.exit(1);
		} finally {
			logger.trace(" SocketServerNettyMain.init() finally");
		}
	}

	/**
	 * 소켓서버 언바인드
	 */
	public void socServerStop() {
		//TODO 소켓 서버 stop 메소드 
		 workerGroup.shutdownGracefully();
		 bossGroup.shutdownGracefully();
	}

	@PreDestroy
	public void destroy() {
		logger.debug("SocketServerMain Destroy Start");
		//TODO 소켓 서버 Destroy 메소드 
		Future<?> wg = workerGroup.shutdownGracefully().syncUninterruptibly();
		Future<?> bg = bossGroup.shutdownGracefully().syncUninterruptibly();
		
		try{
			wg.await();
			bg.await();
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		logger.debug("SocketServerMain Destroy Finished");
	}

}
