package com.company.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {
    private AtomicInteger atomicInteger;

    public Counter(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        atomicInteger.incrementAndGet();
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}
