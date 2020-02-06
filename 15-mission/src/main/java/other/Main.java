package other;

import step2.AccessLimiter;
import step2.SubAccessLimiter;

public class Main {

    public static void main(String[] args) {
        AccessLimiter accessLimiter = new AccessLimiter();

        System.out.println(accessLimiter.publicString);

        SubAccessLimiter subAccessLimiter = new SubAccessLimiter();
        System.out.println(subAccessLimiter.publicString);
    }


}
