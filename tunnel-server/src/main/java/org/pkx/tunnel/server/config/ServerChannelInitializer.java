package org.pkx.tunnel.server.config;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.RequiredArgsConstructor;
import org.pkx.tunnel.server.handler.ServerHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final ServerHandler serverHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
        ch.pipeline().addLast(serverHandler);
    }
}
