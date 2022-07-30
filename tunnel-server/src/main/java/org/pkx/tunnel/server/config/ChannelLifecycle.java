package org.pkx.tunnel.server.config;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChannelLifecycle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        log.trace("通道可用");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx){
        log.trace("通道已被注册");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx){
        log.trace("处理器已增加");
    }
}
