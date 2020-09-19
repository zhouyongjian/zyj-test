package com.zyj.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.zip.Adler32;

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = pool.submit(myTask);
        System.out.println(submit.get());
        pool.shutdown();

    }
}

class MyTask extends RecursiveTask<Integer>{
    private static final Integer ADJUST_VALUE = 10;

    private int begin;
    private int end;
    private int res;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - begin <= ADJUST_VALUE){
            for (int i = begin; i <= end; i++) {
                res = res + i ;
            }
        }else {
            int middle = (end + begin)/2;
            MyTask task01 = new MyTask(begin, middle);
            MyTask task02 = new MyTask(middle + 1, end);
            task01.fork();
            task02.fork();
            res = task01.join() + task02.join();

        }
        return res;
    }
}