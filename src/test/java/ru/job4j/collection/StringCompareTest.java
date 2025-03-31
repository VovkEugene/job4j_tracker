package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Ivanov", "Ivanov");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Ivanov", "Ivanova");
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Petrov", "Ivanova");
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Petrov", "Patrov");
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Patrova", "Petrov");
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftIsPrefixThenResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Ivan", "Ivanov");
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightIsPrefixThenResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Ivanov", "Ivan");
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenBothEmptyThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("", "");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftEmptyRightNonEmptyThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("", "abc");
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftNonEmptyRightEmptyThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("abc", "");
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenBothNullThenThrowException() {
        StringCompare compare = new StringCompare();
        assertThatThrownBy(() -> compare.compare(null, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void whenLeftIsNullThenThrowException() {
        StringCompare compare = new StringCompare();
        assertThatThrownBy(() -> compare.compare(null, "abc"))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void whenRightIsNullThenThrowException() {
        StringCompare compare = new StringCompare();
        assertThatThrownBy(() -> compare.compare("abc", null))
                .isInstanceOf(NullPointerException.class);
    }
}
