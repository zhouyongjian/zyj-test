package com.zyj.netty.chartgroup.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerHandler extends SimpleChannelInboundHandler<String> {
    // 定义一个channel组，管理所有channel,注意static
    // GlobalEventExecutor.INSTANCE是全局的时间执行器，是一个单例
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 表示channel处于活跃状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(sdf.format(new Date())+"---"+ctx.channel().remoteAddress() +" 上线了");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(sdf.format(new Date())+"---"+ctx.channel().remoteAddress() +" 离线了");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    /**
     * 标识建立连接，第一个被执行，将当前channel加入组
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        /**
         * 该方法会将组内多有的channel遍历，并发送消息，不需要自己遍历
         */
        channels.writeAndFlush(sdf.format(new Date())+"---"+"【客户端】"+ ctx.channel().remoteAddress() + " 加入聊天\n");
        channels.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        /**
         * 该方法会将组内多有的channel遍历，并发送消息，不需要自己遍历
         */
        channels.writeAndFlush(sdf.format(new Date())+"---"+"【客户端】"+ ctx.channel().remoteAddress() + " 离开聊天\n");
        System.out.println(sdf.format(new Date())+"---"+"剩余在线人数 ："+channels.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channels.forEach(ch -> {
            if (ch != channel){
                ch.writeAndFlush(sdf.format(new Date())+"---"+"【客户】"+channel.remoteAddress()+ "说："+msg + "\n");
            }else {
                ch.writeAndFlush(sdf.format(new Date())+"---"+"【自己】"+channel.remoteAddress()+ "说："+msg+ "\n");
            }

        });

    }
}
