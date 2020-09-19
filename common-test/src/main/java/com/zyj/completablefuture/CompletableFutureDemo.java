package com.zyj.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 异步调用
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception{

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 没有返回");
        });
        completableFuture.get();


        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 有返回");
//            int i = 10/0;
            return 1024;
        });
        System.out.println(integerCompletableFuture.whenComplete((p1, p2) -> {
            System.out.println("p1 = " + p1);
            System.out.println("p2 = " + p2);
        }).exceptionally(f -> {
            System.out.println("exception:" + f.getMessage());
            return 4444;
        }).get());
    }
}
