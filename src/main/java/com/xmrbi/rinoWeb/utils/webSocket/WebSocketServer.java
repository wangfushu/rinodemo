package com.xmrbi.rinoWeb.utils.webSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WebSocketServer {
	static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
	private static WebSocketServer instance = null;
	private final int serverPort;
    ServerBootstrap serverBootstrap = null;
    EventLoopGroup bossGroup = null;
    EventLoopGroup workerGroup = null;
    
    private WebSocketServer(int serverPort){
    	this.serverPort = serverPort;
    }
    
    public static WebSocketServer getInstance(String serverPort){
    	
    	return getInstance(Integer.parseInt(serverPort));
    }
    
    public static WebSocketServer getInstance(int serverPort){
    	synchronized(WebSocketServer.class){
    		if(instance == null){
    			instance = new WebSocketServer(serverPort);
    		}
    		return instance;
    	}
    }
    
    public void init(){
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
		             .childHandler(new ChannelInitializer<SocketChannel>(){
		            	 @Override
		            	 public void initChannel(SocketChannel ch)throws TooLongFrameException {
		            		 ChannelPipeline channelPipeline = ch.pipeline();
		            		 channelPipeline.addLast(new HttpServerCodec())
		            		 						.addLast(new HttpObjectAggregator(65536))
		            		 						.addLast("handler", new WebSocketServerHandler());
		            	 }
		             }).option(ChannelOption.SO_BACKLOG, 128)	//worker thread 최대 겟수
		             .childOption(ChannelOption.SO_KEEPALIVE, true); // 연결 유지 셋팅

        	ChannelFuture ch = serverBootstrap.bind(serverPort).sync();
        	
        	logger.debug("[{}] ch", ch.toString());
        	logger.info("[ {} ] WebSocket Server Bind", this.serverPort);

        }catch(Exception e){
        	// 웹소켓 바인드 에러
			logger.trace("WEBSOCKET BIND ERROR [{}]", serverPort);
			logger.error(e.getMessage(),e);
			System.exit(1);
        }finally {
        	logger.debug("init() finally {}");
            //bossGroup.shutdownGracefully();
            //workerGroup.shutdownGracefully();
        }
    }
    
    // 언바인드
    public void wsocServerStop(){
    	workerGroup.shutdownGracefully();
    	bossGroup.shutdownGracefully();
    }
    
    // Destroy
    public void destroy() {
    	workerGroup.shutdownGracefully();
    	bossGroup.shutdownGracefully();
    }
}
