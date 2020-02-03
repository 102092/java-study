package ch12.threadName;

public class ThreadNameExample {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("프로그램 시작 스레드"+thread.getName());

        Thread thread1 = new ThreadA();
        System.out.println("ThreadA를 생성한 스레드 "+thread1.getName());
        thread1.start();

        Thread thread2 = new ThreadB();
        System.out.println("ThreadB를 생성한 스레드 "+thread2.getName());
        thread2.start();

    }
}
