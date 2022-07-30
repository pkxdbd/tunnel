package org.pkx.tunnel.server.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

@Slf4j
@Data
public class NettyServer {


    private int port = 8080;
    private InetAddress address;
    private ChannelInitializer<SocketChannel> channelInitializer;
    private ChannelLifecycle channelLifecycle;

    public void run(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(channelLifecycle)
                    .childHandler(channelInitializer)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture future = bootstrap.bind(port).sync();

            log.info("Netty 服务器启动 端口:{}", port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                log.info("服务器停止");
            } else {
                log.error("服务器错误", e);
            }
        } finally {
            try {
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        }
    }

}
