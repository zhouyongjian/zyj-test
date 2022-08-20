package com.zyj.juc;



import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndIncrement();
        LongAdder longAdder = new LongAdder();
        longAdder.increment();

        Thread thread = new Thread(() -> {

        });
        ThreadLocal<Integer>threadLocal = ThreadLocal.withInitial(() -> 0);
        threadLocal.get();
        threadLocal.remove();
        ReentrantLock reentrantLock = new ReentrantLock();






    }

    public static void test() throws InterruptedException {
        Object o = new Object();
        Thread thread = new Thread(() -> {
            synchronized (o){
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("thread 被终止了");
                        break;
                    }

                    System.out.println("11111111111111");
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
//                    try {
//                        TimeUnit.SECONDS.sleep(5);
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                        e.printStackTrace();
//                    }
                }
            }

        });
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }

    public static void completableFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            CompletableFuture<Integer> objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "------start");
                int i = ThreadLocalRandom.current().nextInt(10);
                System.out.println("************" + i);
                if (i < 5){
                    throw new RuntimeException("fadf");
                }
                return  i;

            },executorService).whenComplete((v,e) -> {
                if (e == null){
                    System.out.printf("获取的随机数结果为：" + v);
                }
            }).exceptionally(e -> {
                System.out.printf("异常啦");
                return  null;
            });

            objectCompletableFuture.get();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }


        System.out.println("main over");
    }

    public static void futuretesrows() throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask(() -> {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + "come in task");

            return "over";
        });


        Thread t = new Thread(futureTask, "t1");
        t.start();


        while (true){
            if (futureTask.isDone()){
                System.out.println(futureTask.get());
                break;
            }else {
                try{
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException e){

                    e.printStackTrace();
                }

                System.out.println("doing------");
            }
        }

        System.out.println("main over");
    }
}


