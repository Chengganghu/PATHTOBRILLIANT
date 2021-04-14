package com.company.thread.juc.barrier;

import java.util.Base64;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("all task has finished");
            }
        });

        for (int i = 1; i <= 5; i++) {
            new Thread(new BarrierTask(cyclicBarrier, i * 1000)).start();
        }

    }
}
