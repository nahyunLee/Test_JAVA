package nahyun.test_java.regex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "abab", "ab", "aabb"})
    void ex1(String testString) {
        /**
         * 1. .-> 한 문자
         */
        String pattern = "ab.";

        assertThat(testString.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "abab", "ab", "aabb"})
    void ex2(String testString) {
        /**
         *  ^-> 문자열 시작
         *  $ -> 문자열 끝
         *  */
        String pattern = "^ab$";

        assertThat(testString.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc c", "abab", "ab ", "aabb"})
    void ex3(String testString) {
        /**
         * \s -> whitespace 1 -> 자바에서는 \\
         */
        String pattern = "ab\\s";

        assertThat(testString.matches(pattern)).isTrue();

        String parttern2 = "ab\\s\\s";
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "abab", "ab  ", "aaab  ", "aabbab"})
    void ex3_2(String testString) {
        /**
         * * -> 문자가 0번 이상 발
         */
        String pattern = "ab\\s\\s";

        assertThat(testString.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "abab", "ab", "ab ", "aabbab"})
    void ex3_3(String testString) {
        /**
         * \S -> whilespace 가 아닌 문자  -> 자바에서는 \\
         */
        String pattern = "ab\\S";

        assertThat(testString.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "9"})
    void ex4(String testString) {
        /**
         * [] -> 문자 집합 범위
         * 앞에 ^이면 not
         */
        String pattern = "[1-9]";

        assertThat(testString.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "aA", "Z"})
    void ex5(String testString) {
        /**
         * [] -> 문자 집합 범위
         * 앞에 ^이면 not
         */
        String pattern = "[a-zA-Z]*";

        assertThat(testString.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "a1", "Z"})
    void ex6(String testString) {
        /**
         * [] -> 문자 집합 범위
         * 앞에 ^이면 not
         */
        String pattern = "[1-9a-z]";

        assertThat(testString.matches(pattern)).isTrue();
    }
}
