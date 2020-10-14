package com.zyj.zookeeper.lock.ephemeral;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 临时节点锁
 */
public class ZooEphLock implements Lock {

    private static final String ZK_IP = "127.0.0.1:2181";
    private final ZkClient client = new ZkClient(ZK_IP);
    private final String LOCK_PATH = "/Elock";

    public ZooEphLock() {
        if (!this.client.exists(LOCK_PATH)){
            this.client.createPersistent(LOCK_PATH);
        }
    }

    private CountDownLatch cd = new CountDownLatch(1);
    @Override
    public void lock() {
        if (tryLock()){
            return;
        }
        waitForLock();
        lock();
    }

    private void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {

            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println(Thread.currentThread().getName() +"监听到删除事件");
                cd.countDown();
            }
        } ;
        client.subscribeDataChanges(LOCK_PATH, listener);

        if (client.exists(LOCK_PATH)){
            try{
                cd.await();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        client.unsubscribeDataChanges(LOCK_PATH,listener);
    }


    @Override
    public boolean tryLock() {
        try{
            client.createPersistent(LOCK_PATH);
            return true;

        }catch (Exception e){
            System.out.println(Thread.currentThread().getName() + "---节点存在冲突"+ e.getMessage());
            return false;
        }

    }


    @Override
    public void unlock() {
        client.delete(LOCK_PATH);
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
