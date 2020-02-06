package step2;

public class LambdaExample {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("람다");
            try {
                Thread.sleep(1000);
                System.out.println("1초 후 종료");
            } catch (InterruptedException e) { }
        };
    }
}
