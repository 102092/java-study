package singleton3;

public class TestPattern2 {

  static int nNum = 0;

  public static void main(String[] args) {

    Runnable task = TestPattern2::run;

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(task);
      thread.start();
    }
  }

  private static void run() {
    try {
      nNum++;
      Database database = Database.getInstance(nNum + "번째 데이터 베이스");
      System.out.println("This is the " + database.getName());
    } catch (Exception e) {
    }
  }
}
