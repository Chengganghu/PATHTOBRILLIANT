package com.company.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Counter counter = new Counter(atomicInteger);
        for (int i = 0; i < 5000; i++) {
            new Thread(counter).start();
        }
        System.out.println(counter.getAtomicInteger());
        Thread.sleep(1000);

        UnSafeCounter unSafeCounter = new UnSafeCounter(new Integer(0));
        for (int i = 0; i < 5000; i++) {
            new Thread(unSafeCounter).start();
        }
        System.out.println(unSafeCounter.getNumber());

    }
}
