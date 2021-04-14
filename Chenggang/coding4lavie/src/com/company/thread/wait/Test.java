package com.company.thread.wait;

public class Test {
    public static void main(String[] args) {
        Watcher watcher = new Watcher(10000);
        Counter counter = new Counter(watcher);
        new Thread(counter).start();
        new Thread(counter).start();
        new Thread(counter).start();
    }
}
