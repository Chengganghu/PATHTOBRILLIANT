package com.company.thread.juc.future;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is calculating");
        Thread.sleep(1000);
        return fab(10);
    }

    private int fab(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fab(n -1) + fab(n - 2);
    }
}
