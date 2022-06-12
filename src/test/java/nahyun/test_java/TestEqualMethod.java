package nahyun.test_java;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestEqualMethod {

    /**
     * isSameAs vs isEqualTo
     *  isSameAs : same reference
     *  isEqualTo : equal based on value
     */

    @Test
    void testIsEqualTo() {
        String firstStr = new String("StringTest");
        String secondStr = new String("StringTest");

        assertThat(firstStr).isEqualTo(secondStr);
    }


    @Test
    void testIsSameAs() {
        String firstStr = new String("StringTest");
        String secondStr = new String("StringTest");

        assertThat(firstStr).isSameAs(secondStr);
    }
}
