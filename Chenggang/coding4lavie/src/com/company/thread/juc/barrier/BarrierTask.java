package com.company.thread.juc.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierTask implements Runnable {
    CyclicBarrier cyclicBarrier;
    int executionTime;
    public BarrierTask (CyclicBarrier cyclicBarrier, int executionTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.executionTime = executionTime;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begins to work on task");
            Thread.sleep(executionTime);
            System.out.println(Thread.currentThread().getName() + " finish task");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
