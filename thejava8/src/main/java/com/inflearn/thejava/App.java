package com.inflearn.thejava;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000L); //1초간 Thread를 잠재운다.
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

        });
        thread.start();
        System.out.println("Hello: " + Thread.currentThread().getName());
        thread.join(); //main thread가 thread-0이 3초후 끝날 때 까지 기다렸다가, 진행된다
        System.out.println(thread + "is finished");
    }
}
