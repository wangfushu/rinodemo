package com.xmrbi.rinoWeb.utils.socket;

import com.xmrbi.rinoWeb.utils.SocketMsgQueue;
import com.xmrbi.rinoWeb.vo.GeneralMessage;
import com.xmrbi.rinoWeb.vo.XWSConstants;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.RecvByteBufAllocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/*
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @description :
 * ---------------------------------
 * @Author: wangfushu
 * @Date: 2018-09-13 16:26
*/

public class SocketServerNettyHandler extends ChannelHandlerAdapter {
    static Logger logger = LoggerFactory.getLogger(SocketServerNettyHandler.class);
    //private static final Logger logger = LoggerFactory.getLogger(SocketServerNettyHandler.class);
    private String localPort;
    //ByteBuf 싸이즈 변경 replaying decoder 사용시 replay 횟수 감소
    private static final RecvByteBufAllocator recvByteBufAllocator = new AdaptiveRecvByteBufAllocator(1024, 8192, 32768);

    @Override
    public void channelActive(ChannelHandlerContext ctx) {	// ChannelHandlerContext 오픈시 실행 ( 처음 접속시 )
        localPort = ctx.channel().localAddress().toString().split(":")[1];
        String remoteIp = ctx.channel().remoteAddress().toString().substring(1).split(":")[0];
        System.out.println("localPort =[{}]"+localPort);
        System.out.println("remoteIp =[{}]"+remoteIp);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        ctx.channel().config().setRecvByteBufAllocator(recvByteBufAllocator);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {

        GeneralMessage message = (GeneralMessage) msg;

        System.out.println("[MESSAGE RECEIVE SUCCESS]");

        logger.info("header Typ Cd = {}", new String(message.getHeaderTyp(), XWSConstants.CHAR_SET));
        logger.info("header = {}"+ new String(message.getHeader(),  XWSConstants.CHAR_SET));
        logger.info("body = {}"+new String(message.getBody(), XWSConstants.CHAR_SET));

        logger.info("[Socket Msg Queue] ( Message Receive ) {}", new String(message.getBody(), XWSConstants.CHAR_SET));

        //MsgQueue에 메시지 add
        SocketMsgQueue.getInstance().put(new String(message.getBody(), XWSConstants.CHAR_SET));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println(cause.getMessage());
        ctx.close();
    }

}
