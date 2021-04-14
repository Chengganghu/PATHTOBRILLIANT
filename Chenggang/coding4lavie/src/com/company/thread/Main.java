package com.company.thread;


public class Main {

    public static void main(String[] args) {
        MessageStorage messageStorage = new MessageStorage(10);

        Thread[] threads = new Thread[10];
        for(int i=0;i<5;i++){
            Thread thread = new Thread(new Producer(messageStorage,i));
            threads[i] = thread;
        }

        for(int i=0;i<5;i++){
            Thread thread = new Thread(new Consumer(messageStorage));
            threads[i+5] = thread;
        }

        for(int i=0;i<10;i++){
            Thread thread = threads[i];
            try{
                thread.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
