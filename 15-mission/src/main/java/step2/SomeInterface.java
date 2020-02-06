package step2;

public interface SomeInterface {

    String message = "default access scope";

    default void someMethod() {
        System.out.println(message);
    }

    void blabMethod();
}
