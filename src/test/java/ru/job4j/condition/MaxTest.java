package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxTest {
    @Test
    @DisplayName("Тест метода max(5, 10) -> 10")
    void whenMaxWithTwoNumbersThen10() {
        int first = 5;
        int second = 10;
        int actual = Max.max(first, second);
        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("Тест метода max(7, 7) -> 7")
    void whenMaxWithEqualNumbersThen7() {
        int first = 7;
        int second = 7;
        int actual = Max.max(first, second);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    @DisplayName("Тест метода max(3, 8, 5) -> 8")
    void whenMaxWithThreeNumbersThen8() {
        int first = 3;
        int second = 8;
        int third = 5;
        int actual = Max.max(first, second, third);
        assertThat(actual).isEqualTo(8);
    }

    @Test
    @DisplayName("Тест метода max(-10, -5, -20) -> -5")
    void whenMaxWithThreeNegativeNumbersThenMinus5() {
        int first = -10;
        int second = -5;
        int third = -20;
        int actual = Max.max(first, second, third);
        assertThat(actual).isEqualTo(-5);
    }

    @Test
    @DisplayName("Тест метода max(10, 20, 15, 25) -> 25")
    void whenMaxWithFourNumbersThen25() {
        int first = 10;
        int second = 20;
        int third = 15;
        int fourth = 25;
        int actual = Max.max(first, second, third, fourth);
        assertThat(actual).isEqualTo(25);
    }

    @Test
    @DisplayName("Тест метода max(0, -10, 0, -5) -> 0")
    void whenMaxWithFourNumbersIncludingZeroThen0() {
        int first = 0;
        int second = -10;
        int third = 0;
        int fourth = -5;
        int actual = Max.max(first, second, third, fourth);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("Тест метода max(-30, -20, -40, -10) -> -10")
    void whenMaxWithFourNegativeNumbersThenMinus10() {
        int first = -30;
        int second = -20;
        int third = -40;
        int fourth = -10;
        int actual = Max.max(first, second, third, fourth);
        assertThat(actual).isEqualTo(-10);
    }
}
