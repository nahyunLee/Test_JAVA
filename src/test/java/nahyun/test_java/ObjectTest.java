package nahyun.test_java;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectTest {

    @Test
    void instanceEqualCheckTest() {
        //instanceOf는 (두번째 피연산자와 무관하게) 첫번째 피연산자가 null이면  False를 반환한다.
        String test2 = null;

        boolean instacneOfTest = test2 instanceof String;
        System.out.println(instacneOfTest);
    }
}
