package com.zyj.thread;

public class ThreadTestMain {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("线程启动了");
                try {
                    Thread.sleep(1000 * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束了");
            }
        };
        thread.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();//作用是：在线程阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态
    }
}
