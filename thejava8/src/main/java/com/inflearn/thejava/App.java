package com.inflearn.thejava;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(getRunner("apple"), 1,2, TimeUnit.SECONDS);
//        executorService.shutdown();
    }

    private static Runnable getRunner(String apple) {
        return () -> System.out.println(apple + ": " + Thread.currentThread().getName());
    }
}
