package com.company.thread.juc.lock;

public class MyRunnable implements Runnable{
    private Counter counter;
    public Integer num;
    public MyRunnable(Counter counter, Integer num) {
        this.counter = counter;
        this.num = num;
    }

    @Override
    public void run() {
        counter.increament();
        num++;
        counter.task();
    }
}
