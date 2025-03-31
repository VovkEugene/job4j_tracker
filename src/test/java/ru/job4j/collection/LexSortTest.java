package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {"10. Task.", "1. Task.", "2. Task."};
        String[] output = {"1. Task.", "2. Task.", "10. Task."};
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(output);
    }

    @Test
    public void whenSameNumberThenOrderPreserved() {
        String[] input = {"1. Task A.", "1. Task B."};
        String[] expected = {"1. Task A.", "1. Task B."};
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(expected);
    }

    @Test
    public void whenDifferentNumbersMixedOrder() {
        String[] input = {"5. E Task.", "3. C Task.", "3. B Task.", "10. J Task.", "2. A Task."};
        String[] output = {"2. A Task.", "3. C Task.", "3. B Task.", "5. E Task.", "10. J Task."};
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(output);
    }

    @Test
    public void whenLeadingZerosThenParsedAsSameNumber() {
        String[] input = {"01. Task.", "1. Task.", "10. Task."};
        String[] expected = {"01. Task.", "1. Task.", "10. Task."};
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(expected);
    }

    @Test
    public void whenInvalidFormatThenNumberFormatException() {
        String[] input = {"abc Task.", "1. Task."};
        assertThatThrownBy(() -> Arrays.sort(input, new LexSort()))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void whenDifferentLengths() {
        String[] input = {"100. LongTask", "20. MediumTask", "3. Short"};
        String[] expected = {"3. Short", "20. MediumTask", "100. LongTask"};
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(expected);
    }
}