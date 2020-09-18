package com.zyj.demo.netty.chartgroup.server;

import com.zyj.demo.netty.chartgroup.client.ChatGroupClient;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 群聊服务端
 */
public class ChatGroupServer {
    private  int port = 0;
    public ChatGroupServer(int port){
        this.port = port;
    }
    public void startServer() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1); //设置一个boss 处理accept事件
        EventLoopGroup workerGroup = new NioEventLoopGroup(3); //设置3个worker,不设置默认cpu核数*2
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) // 设置channel类型，为服务端channerl
                    .option(ChannelOption.SO_BACKLOG , 1024).childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new StringDecoder()).addLast(new StringEncoder()).addLast(new ServerHandler());
                        }
                    });

            ChannelFuture sync = server.bind(port).sync();
            System.out.println("群聊服务端启动了");
            sync.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ChatGroupServer(9999).startServer();
    }
}
