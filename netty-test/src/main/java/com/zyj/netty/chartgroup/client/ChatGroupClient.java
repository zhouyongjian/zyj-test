package com.zyj.netty.chartgroup.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class ChatGroupClient {
    private final String host;
    private final int port;
    public ChatGroupClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void startClient(){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);
        Bootstrap bootstrap = new Bootstrap();
        try{
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new StringDecoder()).addLast(new StringEncoder()).addLast();
                    pipeline.addLast(new ClientHandler());
                }
            });
            ChannelFuture sync = bootstrap.connect(host, port).sync();
            Channel channel = sync.channel();
            System.out.println("-------客户端"+channel.localAddress()+"启动了-----\n");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String s = scanner.nextLine();
                channel.writeAndFlush(s+ "\r\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatGroupClient("127.0.0.1", 9999).startClient();
    }
}
