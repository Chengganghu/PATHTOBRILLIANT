package com.company.thread;

import java.util.LinkedList;
import java.util.List;

public class MessageStorage {
    private int maxSize;
    private List<String> messages;

    public MessageStorage(int maxSize) {
        this.maxSize = maxSize;
        messages = new LinkedList<>();
    }

    public void set(String message) throws InterruptedException {
        synchronized (this) {
            while (messages.size() == maxSize) {
                System.out.println("message buffer is full, wait now");
                wait();
            }
            Thread.sleep(1000);
            messages.add(message);
            System.out.println("add message " + message + " success, " + messages.size() + " left");
            notifyAll();
        }
    }

    public String get() throws InterruptedException {
        String message = null;
        synchronized (this) {
            while (messages.size() == 0) {
                System.out.println("message buffer is empty, wait now");
                wait();
            }
            Thread.sleep(1000);
            message = ((LinkedList<String>)messages).poll();
            System.out.println("get message " + message + " success, " + messages.size() + " left");
            notifyAll();
        }
        return message;
    }
 }
