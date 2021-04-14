package com.company.thread.juc.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreService implements Runnable{
    private Semaphore semaphore;

    public SemaphoreService(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is doing something");
            Thread.sleep(1000);
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
