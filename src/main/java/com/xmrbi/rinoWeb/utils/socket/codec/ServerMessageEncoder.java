package com.xmrbi.rinoWeb.utils.socket.codec;


import com.xmrbi.rinoWeb.vo.GeneralMessage;
import com.xmrbi.rinoWeb.vo.XWSConstants;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class ServerMessageEncoder extends MessageToByteEncoder<GeneralMessage> {
	static Logger logger = LoggerFactory.getLogger(ServerMessageEncoder.class);
	@Override
    protected void encode(final ChannelHandlerContext ctx, GeneralMessage gm, ByteBuf out) {
		try {
			logger.trace("ACK RETURN [{}]", new String(gm.getHeader(),XWSConstants.CHAR_SET));
			out.writeBytes(gm.getHeader());
			out.release();
			ctx.flush();
//			out.writeBytes(gm.getBody());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(),e);
		}
    }
}