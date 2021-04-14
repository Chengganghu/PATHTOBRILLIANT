package com.company.thread.juc.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();


        FutureTask<Integer> futureTask1 = new FutureTask<>(task);
        new Thread(futureTask1).start();

        System.out.println(futureTask.get());
        System.out.println(futureTask1.get());

    }
}
