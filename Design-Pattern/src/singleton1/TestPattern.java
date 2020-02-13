package singleton1;

public class TestPattern {

  public static void main(String[] args) {
    Database database;
    database = Database.getInstance("첫번째 database");
    System.out.println(database.getName());

    database = Database.getInstance("두번째 Database");
    System.out.println(database.getName());

  }
}
