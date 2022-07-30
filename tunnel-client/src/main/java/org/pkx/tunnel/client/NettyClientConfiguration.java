package org.pkx.tunnel.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class NettyClientConfiguration {

    @Bean
    public NettyClient nettyJTServer(ServerProperties serverProperties, ChannelInitializer<SocketChannel> channelInitializer){
        NettyClient nettyServer = new NettyClient();
        nettyServer.setPort(serverProperties.getPort());
        nettyServer.setAddress(serverProperties.getAddress());
        nettyServer.setChannelInitializer(channelInitializer);
        return nettyServer;
    }
}
