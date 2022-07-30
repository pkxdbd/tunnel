package org.pkx.tunnel.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Data;

import java.net.InetAddress;

@Data
public class NettyClient {

    private int port = 8080;
    private InetAddress address;
    private ChannelInitializer<SocketChannel> channelInitializer;


    public void run(){
        try {
            //客户端需要一个事件循环组
            EventLoopGroup eventExecutors = new NioEventLoopGroup();

            //创建客户端启动对象
            //注意客户端使用的不是ServerBootstrap而是Bootstrap
            Bootstrap bootstrap = new Bootstrap();

            //设置相关参数
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(channelInitializer);
            ChannelFuture sync = bootstrap.connect(address.getHostAddress(), port).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
