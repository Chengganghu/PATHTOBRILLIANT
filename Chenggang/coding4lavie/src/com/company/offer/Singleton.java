package com.company;

public class Singleton {

    // volatile关键字用于禁止指令重排序，防止对象还未创建完毕，别的线程就拿去使用
    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {  // double check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    // 相较于上面的方法，此方法效率低，因为每次都需要获得锁才能进行
    public static Singleton getInstance1() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
