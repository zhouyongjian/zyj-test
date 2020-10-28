package com.zyj.netty.idelexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 群聊服务端
 */
public class MyServer {
    private  int port = 0;
    public MyServer(int port){
        this.port = port;
    }
    public void startServer() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1); //设置一个boss 处理accept事件
        EventLoopGroup workerGroup = new NioEventLoopGroup(3); //设置3个worker,不设置默认cpu核数*2
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) // 设置channel类型，为服务端channerl
                    .option(ChannelOption.SO_BACKLOG , 1024).childOption(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new IdleStateHandler(5, 7, 10, TimeUnit.SECONDS));
                            pipeline.addLast(new MyServerHandler());


                        }
                    });

            ChannelFuture sync = server.bind(port).sync();
            sync.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new MyServer(8899).startServer();
    }
}
