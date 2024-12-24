package ru.job4j.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FactorialTest {
    @Test
    @DisplayName("Тест проверяет, что метод выбрасывает исключение IllegalArgumentException")
    public void whenCalcTrowsException() {
        assertThatThrownBy(() -> new Factorial().calc(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number could not be less than 0");
    }
}