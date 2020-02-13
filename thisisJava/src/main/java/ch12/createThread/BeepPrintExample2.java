package ch12.createThread;

import java.awt.Toolkit;

public class BeepPrintExample2 {

  public static void main(String[] args) {

    // 1번 방법으로 thread 생성
//        Runnable beepTask = new BeepTask();
//        Thread thread = new Thread(beepTask);
//        thread.start();

    //2번 방법
/*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try{ Thread.sleep(500); }catch (Exception e){};
                }

            }
        });
        thread.start();
*/

    //3번
    Thread thread = new Thread(() -> {
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      for (int i = 0; i < 5; i++) {
        toolkit.beep();
        try {
          Thread.sleep(500);
        } catch (Exception e) {
        }
      }
    });
    thread.start();

    for (int i = 0; i < 5; i++) {
      System.out.println("띵");
      try {
        Thread.sleep(500);
      } catch (Exception e) {
      }
    }
  }
}
