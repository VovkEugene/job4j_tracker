package ru.job4j.tracker.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.MockOutput;
import ru.job4j.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    private MockInput in;
    private Output output;

    @BeforeEach
    public void setUp() {
        output = new MockOutput();
    }

    @Test
    @DisplayName("Тест проверяет, что пользователь ввел сначала неверные данные, а потом верные.")
    public void whenInvalidInput() {
        in = new MockInput(new String[]{"one", "1"});
        ValidateInput input = new ValidateInput(in, output);
        int actual = input.askInt("Enter menu:");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("Тест проверяет, что пользователь ввел верные данные.")
    public void whenValidInput() {
        in = new MockInput(new String[]{"0"});
        ValidateInput input = new ValidateInput(in, output);
        int actual = input.askInt("Enter menu:");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("Тест проверяет, что пользователь многократно ввел верные данные.")
    public void whenManyValidInput() {
        String[] answers = {"0", "1", "2", "3"};
        in = new MockInput(answers);
        ValidateInput input = new ValidateInput(in, output);
        for (int i = 0; i < answers.length; i++) {
            int actual = input.askInt("Enter menu:");
            assertThat(actual).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("Тест проверяет, что пользователь ввел отрицательное число.")
    public void whenNegativeNumberInput() {
        in = new MockInput(new String[]{"-1"});
        ValidateInput input = new ValidateInput(in, output);
        int actual = input.askInt("Enter menu:");
        assertThat(actual).isEqualTo(-1);
    }
}