package ru.job4j.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountTest {
    @ParameterizedTest
    @CsvSource({"1, 6, 15", "1, 11, 55", "0, 1, 0", "-5, 1, -15", "-3, 0, -6", "0, 0, 0"})
    @DisplayName("Тест проверяет, что результат совпадает с ожидаемым")
    void whenAddWithValidRanges(int start, int finish, int expected) {
        assertThat(Count.add(start, finish)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10, 1", "5, -1", "0, -10"})
    @DisplayName("Тест проверяет, что метод выбрасывает исключение IllegalArgumentException")
    void whenAddWithInvalidRanges(int start, int finish) {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> Count.add(start, finish));
        assertThat(exception.getMessage()).isEqualTo("Start should be less than finish");
    }
}