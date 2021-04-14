package com.company.thread.wait;

public class Counter implements Runnable {
    private Watcher watcher;
    public Counter(Watcher watcher) {
        this.watcher = watcher;
    }

    @Override
    public void run() {
        synchronized (watcher) {
            while(watcher.getNumber() > 0) {
                watcher.setNumber(watcher.getNumber() - 1);
                System.out.println("number is " + watcher.getNumber());
            }
        }
    }
}
