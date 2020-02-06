package step2;

public class OverLoading {

    public void loading() {
        System.out.println("매개인자가 없음");
    }

    public void loading(String a, String b) {
        System.out.println("String "+a+" "+b);
    }

    public void loading(String a, String b, String c) {
        System.out.println("String "+a+" "+b+" "+c);
    }
}
