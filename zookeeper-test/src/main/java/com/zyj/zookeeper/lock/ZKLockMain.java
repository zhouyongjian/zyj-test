package com.zyj.zookeeper.lock;

import com.zyj.zookeeper.lock.persistent.ZooPerLock;
import org.apache.zookeeper.ZooKeeper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class ZKLockMain {
    private  int i = 0;
    public static CountDownLatch cd = new CountDownLatch(10);
    public static void main(String[] args) {
        ZooPerLock zooPerLock = new ZooPerLock();
//        zooPerLock.lock();

        for (int i = 0; i < 10 ; i++) {
            new Thread(new MyThead(zooPerLock)).start();
//            cd.countDown();
        }
    }


}

class MyThead implements Runnable{
    private ZooPerLock zooPerLock;
    public MyThead(ZooPerLock zooPerLock ) {
        this.zooPerLock = zooPerLock;
    }

    public static int i = 0;
    @Override
    public void run() {
        try {
//            ZKLockMain.cd.await();
            zooPerLock.lock();
            System.out.println(Thread.currentThread().getName()+"----"+createNum());
            zooPerLock.unlock();

        } catch (Exception e) {

        }

    }

    public String createNum(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date())+ "---"+ ++i;
    }
}
