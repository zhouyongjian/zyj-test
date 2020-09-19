package com.zyj.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws Exception{

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        if (!socketChannel.connect(new InetSocketAddress("127.0.0.1",6666)) ){
            while (!socketChannel.finishConnect()){
                System.out.println("客户端没有建立连接，连接中、、、、");
            }
        }
        String str = "12335435affdasfadsf";
        socketChannel.write(ByteBuffer.wrap(str.getBytes()));
        ByteBuffer bf = ByteBuffer.allocate(1024);
        socketChannel.read(bf);
        System.out.println(new String(bf.array()));
        System.in.read();
    }
}
