package com.zyj.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {
    public static void main(String[] args) {

        ReentrantLock rl = new ReentrantLock();
        new Thread(() -> {
            try {
                rl.lock();
                System.out.println(Thread.currentThread().getName() +"----come in");

                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                rl.unlock();
            }
        },"A").start();

        new Thread(() -> {
            try {
                rl.lock();
                System.out.println(Thread.currentThread().getName() +"----come in");

                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                rl.unlock();
            }
        },"B").start();

        new Thread(() -> {
            try {
                rl.lock();
                System.out.println(Thread.currentThread().getName() +"----come in");

                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                rl.unlock();
            }
        },"C").start();


        System.out.println(1);



    }
}
