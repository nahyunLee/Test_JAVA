package nahyun.test_java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImmutableTest {

    @Test
    @DisplayName("final도 값변경 가능")
    void changeFinalVariable() {
        final List<String> stringList = Arrays.asList("hello", "world");

        stringList.add("hi");

        System.out.println(stringList);
    }


    @Test
    @DisplayName("불변객체에도 재할당 가능")
    void testMutable() {
        //given
        ArrayList<String> exList = new ArrayList<>();
        exList.add("nahyun");
        exList.add("lee");

        final MutableClass name = new MutableClass(exList);
        List<String> nameList = name.getList();

        //when
        nameList.add("change");

        //then
        assertThat(nameList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("진짜 불변객체")
    void testImmutable() {
        //given
        ArrayList<String> exList = new ArrayList<>();
        exList.add("nahyun");
        exList.add("lee");

        final ImmutableClass name = new ImmutableClass(exList);
        List<String> nameList = name.getList();

        //when
        assertThrows(UnsupportedOperationException.class, () -> nameList.add("change"));
    }
    
    static final class MutableClass {
        private final List<String> list;

        public MutableClass(List<String> list) {
            this.list = list;
        }

        public List<String> getList() {
            return list;
        }
    }

    static final class ImmutableClass {
        private final List<String> list;

        public ImmutableClass(List<String> list) {
            this.list = list;
        }

        public List<String> getList() {
            return Collections.unmodifiableList(list);
        }
    }

    @Test
    @DisplayName("final 키워드는 재할당 금지. 내부 값 변경 가능")
    void test_change_MutableClass() {
        final MutableClass2 mutableClass2 = new MutableClass2(1);

        mutableClass2.value = 2;

        assertThat(mutableClass2.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("참조변수 내부까지 immutable하도록 하면 참조 변수까지 immutable")
    void test_change_ImmutableClass() {
        final ImmutableClass2 immutableClass2 = new ImmutableClass2(1);
//
//        //immutable한 변수라서 애초에 접근 자체가 불가
//        immutableClass2.value = 2;
    }

    static class MutableClass2 {
        private int value;

        public MutableClass2(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static class ImmutableClass2 {
        private final int value;

        public ImmutableClass2(int value) {
            this.value = value;
        }
    }
}

