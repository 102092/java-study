package com.inflearn.thejava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "keesun";
        };

        String s = executorService.invokeAny(Arrays.asList(hello, java, keesun)); //blocking call, 바로 결과가 나옴.
        System.out.println(s);
        executorService.shutdown();
    }
}
