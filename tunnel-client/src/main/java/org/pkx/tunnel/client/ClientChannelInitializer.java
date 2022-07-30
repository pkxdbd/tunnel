package org.pkx.tunnel.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final ClientHandler serverHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(serverHandler);
    }
}
