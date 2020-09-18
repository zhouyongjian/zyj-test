package com.zyj.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel open = ServerSocketChannel.open();
        Selector selector = Selector.open();
        open.socket().bind( new InetSocketAddress(6666));
        open.configureBlocking(false);
        open.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务者 = " + open.hashCode());
        while (true){
            if (selector.select(1000) > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()){
                        ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                        System.out.println("服务者 = " + ssc.hashCode());
                        SocketChannel accept = ssc.accept();
                        System.out.println("客户端建立连接了" + accept.hashCode());
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));// 此处不指定第三个参数的bytebuffer.下面mark初会发生空指针异常，以为没有指定。。。。

                    }
                    if (key.isReadable()){
                        SocketChannel channel = (SocketChannel)key.channel();
                        System.out.println("可读客户端建立连接了" + channel.hashCode());
                        ByteBuffer attachment = (ByteBuffer)key.attachment();// mark
                        channel.read(attachment);
                        System.out.println("msg = " + new String(attachment.array()));
                    }
                }


            }else {
                System.out.println("一秒钟过去了，一个连接也没有");
            }
        }

    }
}
