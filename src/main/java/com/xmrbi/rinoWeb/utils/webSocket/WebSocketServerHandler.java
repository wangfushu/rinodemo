package com.xmrbi.rinoWeb.utils.webSocket;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpHeaders.Names.HOST;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Handles handshakes and messages
 */
public class WebSocketServerHandler extends ChannelInboundHandlerAdapter {
	static Logger logger = LoggerFactory.getLogger(WebSocketServerHandler.class);
	private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
    private static final String WEBSOCKET_PATH = "/websocket";

    private WebSocketServerHandshaker handshaker;
    
    public static ChannelGroup getChannelGroup(){
    	return channels;
    }

    // Client Connect 请求连接
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws IllegalArgumentException , ClassCastException, UnsupportedOperationException  {
    	
    	Channel incoming = ctx.channel();
    	channels.add(incoming);
    	logger.info("[SERVER] : {} has joined", incoming.remoteAddress());
    }
    
    // Client Disconnect 请求连接
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws ClassCastException, UnsupportedOperationException  {
    	
    	Channel incoming = ctx.channel();
    	logger.info("[SERVER] : {} has left", incoming.remoteAddress());
    	channels.remove(incoming);
    }
    
    // Client在传输时
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
		if (msg instanceof FullHttpRequest) {									// Client 第一次连接
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {						//接收数据和断开连接时
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }
    
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        // Handle a bad request.
        if (!req.getDecoderResult().isSuccess()) {
            sendHttpResponse(ctx.channel(), req, new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
            return;
        }

        // Allow only GET methods.
        if (req.getMethod() != GET) {
            sendHttpResponse(ctx.channel(), req, new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN));
            return;
        }

        if ("/favicon.ico".equals(req.getUri())) {
            FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, NOT_FOUND);
            sendHttpResponse(ctx.channel(), req, res);
            return;
        }

        // Handshake
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                getWebSocketLocation(req), null, true);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        // Check for closing frame
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        
        // Check for connect frame
        if (frame instanceof PingWebSocketFrame) {
        	ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        
        // Data Send frame
        if(frame instanceof TextWebSocketFrame){
        	for(Channel channel : channels){
        		synchronized (channel) {
        			channel.write(new TextWebSocketFrame(((TextWebSocketFrame) frame).text()));
        			channel.flush();
				}
        	}
        }
    }

    private static void sendHttpResponse(Channel channel, FullHttpRequest req, FullHttpResponse res) {
        // Generate an error page if response getStatus code is not OK (200).
        if (res.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
            HttpHeaders.setContentLength(res, res.content().readableBytes());
        }

        // Send the response and close the connection if necessary.
        ChannelFuture f = channel.writeAndFlush(res);
        if (!HttpHeaders.isKeepAlive(req) || res.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    // SERVER의 WebSocket Path Get
    private static String getWebSocketLocation(FullHttpRequest req) {
        String location =  req.headers().get(HOST) + WEBSOCKET_PATH;
        return "ws://" + location;
    }
    
}
