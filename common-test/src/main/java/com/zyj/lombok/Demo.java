package com.zyj.lombok;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 如果先unpark,则park不会起作用，即线程不会阻塞
         */
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "----come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "-----被唤醒");

        } , "a");
        a.start();
        TimeUnit.SECONDS.sleep(5);

        Thread b = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "----come in");
            LockSupport.unpark(a);
        } , "b");
        b.start();
    }
}
