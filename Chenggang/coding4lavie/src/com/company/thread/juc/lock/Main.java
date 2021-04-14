package com.company.thread.juc.lock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
//        Integer num = new Integer(0);
//        for (int i = 0; i < 5000; i++) {
//            new Thread(new MyRunnable(counter, num)).start();
//        }
//        System.out.println(counter.num);
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        Thread.sleep(4000);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t1.interrupt();
//            }
//        }).start();
        Thread thread = new Thread(new MyRunnable(counter, new Integer(0)));
        thread.start();
        Thread.interrupted();
    }
}
