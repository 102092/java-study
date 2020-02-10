import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


/*
https://reiphiel.tistory.com/entry/junit5-features
 */

public class StringCalculatorTest {

    @Test
    public void null_또는_반값() {
        assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    public void 값_하나() {
        assertThat(StringCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    public void 쉼표_구분자() {
        assertThat(StringCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    public void 쉼표_콜론_구분자() {
        assertThat(StringCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    public void 음수값() {
        Throwable throwable = assertThrows(RuntimeException.class, () -> {
            StringCalculator.splitAndSum("-1,2:3");
        });
    }
}
