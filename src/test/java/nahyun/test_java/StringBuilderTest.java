package nahyun.test_java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringBuilderTest {

    @Test
    @DisplayName("StringBuilder에 아무 값도 append하지 않았을 떄의 결과값 확인")
    void testStringBuilder_withNoAppend() {
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("stringBuilder = " + stringBuilder);

        Assertions.assertThat(stringBuilder.toString()).isEqualTo("");
    }
}
