package step2;

public class Main {

    public static void main(String[] args) {
        AccessLimiter accessLimiter = new AccessLimiter();

        System.out.println(accessLimiter.defaultString);
        System.out.println(accessLimiter.protectedString);
        System.out.println(accessLimiter.publicString);
        System.out.println(enumExample.NAME);
    }
}
