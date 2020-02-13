package singleton3;

public class Database {

  private static Database singleTon = new Database("products");
  private String name;

  private Database(String name) {
    try {
      Thread.sleep(100);
      this.name = name;
    } catch (Exception e) {
    }
  }

  public static Database getInstance(String name) {
    return singleTon;
  }

  public String getName() {
    return name;
  }

}
