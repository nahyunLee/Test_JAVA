package nahyun.test_java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GenericTest {

    @Test
    @DisplayName("List형태도 제네릭 타입 적용 가능한지 테스트")
    void testListGeneric() {
        List<String> testList = new ArrayList<>();
        testList.add("nahyun");
        testList.add("test");

        GenericClass genericClass = new GenericClass(testList);

        System.out.println(genericClass.getField());
    }

    static class GenericClass<T>{
        private T field;

        public GenericClass(T field) {
            this.field = field;
        }

        public String getField() {
            return field.toString();
        }
    }
}
