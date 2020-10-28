package com.zyj.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileByBuffer {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("input.txt");
        FileOutputStream fos = new FileOutputStream("output.txt");
        FileChannel fcin = fis.getChannel();
        FileChannel foout= fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer direct = ByteBuffer.allocateDirect(1024);
        while (true){
            buffer.clear();
            int read = fcin.read(buffer);
            System.out.println("read = "+ read);
            if (-1 == read){
                break;
            }
            buffer.flip();
            foout.write(buffer);

        }
        fis.close();
        fos.close();

    }
}
