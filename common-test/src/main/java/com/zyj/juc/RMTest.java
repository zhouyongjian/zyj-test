package com.zyj.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RMTest {
    public  static int a = 0;
    public static void main(String[] args) throws Exception{

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();


        new Thread(() ->{
            writeLock.lock();
            System.out.println("t1 write lock");
            try {
                a= 1;
                readLock.lock();

                writeLock.unlock();
                System.out.println("unlock ");

                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("sleep over");


            }finally {
                readLock.unlock();
            }

        }).start();

        new Thread(() -> {
            readLock.lock();
            System.out.println(" t2 readlock");
            try{
                System.out.println("in read   " + a);
            }finally {
                readLock.unlock();
                System.out.println("t2 over");
            }
        }).start();


        new Thread(() -> {
            writeLock.lock();
            System.out.println(" t3 wreite");
            try{
                System.out.println("t 3 in read   " + a);
            }finally {
                writeLock.unlock();
            }
        }).start();
    }
}
