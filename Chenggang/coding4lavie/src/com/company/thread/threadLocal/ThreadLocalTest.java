package com.company.thread.threadLocal;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static void print(String str) {
        System.out.println(str + " : " + threadLocal.get());
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread local var 1");
                print(threadLocal.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread local var 2");
                print(threadLocal.get());
            }
        });

        t1.start();
        t2.start();
    }
}
