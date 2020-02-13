package singleton1;

public class TestPattern2 {

  static int NUM = 0;

  public static void main(String[] args) {

    Runnable task = TestPattern2::run;

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(task);
      thread.start();
    }
  }

  private static void run() {
    try {
      NUM++;
      Database database = Database.getInstance(NUM + "번째 데이터 베이스");
      System.out.println("This is the " + database.getName());
    } catch (Exception e) {
    }
  }
}
