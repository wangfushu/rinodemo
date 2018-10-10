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
    	// NioEventLoopGroup 是一个多线程事件循环
		// bossGroup接受传入的连接
		// workerGroup处理连接
    	bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        try {
        	// ServerBootstrap服务器设置帮助程序类
        	serverBootstrap = new ServerBootstrap();
        	serverBootstrap.group(bossGroup, workerGroup)
        	// NioServerSocketChannel使用类创建新通道（实例化）
		             .channel(NioServerSocketChannel.class)
		             .childHandler(new ChannelInitializer<SocketChannel>(){
		            	 @Override
		            	 public void initChannel(SocketChannel ch)throws TooLongFrameException {
		            		 ChannelPipeline channelPipeline = ch.pipeline();
		            		 channelPipeline.addLast(new HttpServerCodec())
		            		 						.addLast(new HttpObjectAggregator(65536))
		            		 						.addLast("handler", new WebSocketServerHandler());
		            	 }
		             }).option(ChannelOption.SO_BACKLOG, 128)	//worker thread 最大数量
		             .childOption(ChannelOption.SO_KEEPALIVE, true); //连接维护设置

        	ChannelFuture ch = serverBootstrap.bind(serverPort).sync();
        	
        	logger.debug("[{}] ch", ch.toString());
        	logger.info("[ {} ] WebSocket Server Bind", this.serverPort);

        }catch(Exception e){
        	// Web套接字绑定错误
			logger.trace("WEBSOCKET BIND ERROR [{}]", serverPort);
			logger.error(e.getMessage(),e);
			System.exit(1);
        }finally {
        	logger.debug("init() finally {}");
            //bossGroup.shutdownGracefully();
            //workerGroup.shutdownGracefully();
        }
    }
    
    // 解除绑定
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
