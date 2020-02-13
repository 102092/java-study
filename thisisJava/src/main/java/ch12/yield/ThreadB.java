package ch12.yield;

public class ThreadB extends Thread {

  public boolean stop = false;
  public boolean work = true;

  @Override
  public void run() {
    while (!stop) {
      if (work) {
        System.out.println("ThreadB 작업 내용");
      } else {
        Thread.yield();
      }
    }
    System.out.println("ThreadB 종료");
  }
}
