package com.company.thread.juc.latch;

import java.util.concurrent.CountDownLatch;

public class LatchTask implements Runnable {
    private CountDownLatch countDownLatch;

    public LatchTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task finished");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
