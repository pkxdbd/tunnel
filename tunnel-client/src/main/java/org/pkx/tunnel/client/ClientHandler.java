package org.pkx.tunnel.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接建立成功");
        for (int i = 0; i < 5; i++) {
//            Unpooled.copiedBuffer()
//            ByteBuf hello = Unpooled.copiedBuffer("hello", Charset.defaultCharset());
            ByteBuf byteBuf = Unpooled.buffer(10);
            byteBuf.writeInt(5);
            byteBuf.writeBytes("abcde".getBytes(StandardCharsets.UTF_8));
            ctx.writeAndFlush(byteBuf);
        }
        ctx.fireChannelActive();
    }
}
