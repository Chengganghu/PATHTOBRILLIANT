package com.company.thread.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    public Integer num ;
    private Lock lock;
    public Counter(Integer num) {
        this.num = num;
        lock = new ReentrantLock();
    }
    public synchronized void increament() {
        lock.lock();
        this.num++;
        lock.unlock();
    }


    public void task() {
        try {
            lock.lockInterruptibly();
            System.out.println("fib begins");
            fib(1000);
            System.out.println("succeed get lock and finish task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private int fib (int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
