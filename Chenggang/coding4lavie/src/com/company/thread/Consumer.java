package com.company.thread;

public class Consumer implements Runnable{
    private MessageStorage messageStorage;

    public Consumer(MessageStorage messageStorage) {
        this.messageStorage = messageStorage;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                messageStorage.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
