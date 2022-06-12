package nahyun.test_java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringPoolTest {

    /**
     * String을 만드는 방법 2가지
     * 1. new연산자로 만들기
     * 2. 리터럴로 만들기
     *      1. Heap 내부의 String Constant Pool영역에 저장됨
     */

    @Test
    void testStringObject() {
        String firstStr = new String("StringTest");
        String secondStr = new String("StringTest");

        assertThat(firstStr).isSameAs(secondStr);
        assertThat(firstStr).isEqualTo(secondStr);
    }

    @Test
    void testStringPool() {
        // fistStr, secondStr 은 Stack메모리에
        // "StringTest"값은 StringPool에 저장, 그 주소가 변수에 저장
        // String pool에 저장될 때는 intern()메소드 실행
        String firstStr = "StringTest";
        String secondStr = "StringTest";

        assertThat(firstStr).isSameAs(secondStr);
    }


    /**
     * String interning
     * intern() : String과 동등한 String 객체가 이미 String pool에 존재한다면 그 객체를 그대로 리턴
     */
    @Test
    void testStringInterning_WithConstantString() {
        String constantString = "StringTest";
        String internedString = constantString.intern();

        assertThat(constantString).isSameAs(internedString);
    }

    @Test
    void testStringInterning_WithNewString() {
        String newString = new String("StringTest");
        String internedString = newString.intern();

        assertThat(newString).isNotSameAs(internedString);
    }
}
