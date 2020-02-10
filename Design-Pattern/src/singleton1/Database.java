package singleton1;

public class Database {
    private static Database singleTon;
    private String name;

    private Database(String name) {
        try {
            Thread.sleep(100);
            this.name = name;
        } catch (Exception e) {
        }
    }

    public static Database getInstance(String name) {
        if (singleTon == null) {
            singleTon = new Database(name);
        }
        return singleTon;
    }

    public String getName() {
        return name;
    }

}
