package org.pkx.tunnel.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf1 = (ByteBuf) msg;

        byte[] content = new byte[buf1.readableBytes()];
        buf1.readBytes(content);
        System.out.println(new String(content, StandardCharsets.UTF_8));
    }


}
