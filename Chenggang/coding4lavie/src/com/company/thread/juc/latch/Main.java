package com.company.thread.juc.latch;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws Exception {
//        Task task = new Task();
//
//        long time = new LatchTest().timeTasks(10, task);
//        System.out.println(time);

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            new Thread(new LatchTask(countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("all task finished");
    }
}
