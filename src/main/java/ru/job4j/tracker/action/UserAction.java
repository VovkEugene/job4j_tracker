package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Tracker;

public interface UserAction {
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    String RESET = "\u001B[0m";
    String MESSAGE_ERROR =
            "Нужно ввести число от 0 до 6, что соответствует операциям в меню.";

    String name();

    boolean execute(Input input, Tracker tracker);
}
