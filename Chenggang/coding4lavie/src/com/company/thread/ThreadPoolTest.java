package com.company.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        String s = "thread pool";
        for (int i = 0; i < 100; i++) {
            Future<String> future = executorService.submit(() -> s);
        }
    }

    class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            return null;
        }
    }
}
