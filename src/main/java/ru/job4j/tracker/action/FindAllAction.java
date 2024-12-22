package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        output.println("\n=== Вывод всех заявок ===");
        if (items.length == 0) {
            output.println("\n\tХранилище еще не содержит заявок.");
        } else {
            for (Item item : items) {
                output.println(item);
            }
        }
        return true;
    }
}
