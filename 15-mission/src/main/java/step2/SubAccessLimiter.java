package step2;

public class SubAccessLimiter extends AccessLimiter {

    public static void main(String[] args) {
        SubAccessLimiter subAccessLimiter = new SubAccessLimiter();
        System.out.println(subAccessLimiter.defaultString);
        System.out.println(subAccessLimiter.protectedString);
        System.out.println(subAccessLimiter.publicString);
    }
}
