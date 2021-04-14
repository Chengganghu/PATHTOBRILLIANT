package com.company.thread.juc.executor;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<Integer> future2 = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 3000;
            }
        });

        CompletionService<Integer> service = new ExecutorCompletionService<>(executor);
        service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 5000;
            }
        });

        service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(4000);
                return 4000;
            }
        });

        service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 3000;
            }
        });

        for (int i = 0; i < 3; i++) {
            System.out.println(service.take().get());
        }

        executor.shutdownNow();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
