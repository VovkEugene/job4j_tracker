package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

import static ru.job4j.tracker.action.UserAction.RED;
import static ru.job4j.tracker.action.UserAction.RESET;

public class ValidateInput implements Input {
    private final Input input;
    private final Output output;

    public ValidateInput(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        while (invalid) {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println(RED + "Пожалуйста, введите корректные данные" + RESET);
            }
        }
        return value;
    }
}
