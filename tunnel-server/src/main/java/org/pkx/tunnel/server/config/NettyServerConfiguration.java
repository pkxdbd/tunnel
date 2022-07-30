package org.pkx.tunnel.server.config;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class NettyServerConfiguration {

    @Bean
    public NettyServer nettyJTServer(ServerProperties serverProperties, ChannelInitializer<SocketChannel> channelInitializer,ChannelLifecycle channelLifecycle){
        NettyServer nettyServer = new NettyServer();
        nettyServer.setPort(serverProperties.getPort());
        nettyServer.setChannelLifecycle(channelLifecycle);
        nettyServer.setChannelInitializer(channelInitializer);
        return nettyServer;
    }
}
