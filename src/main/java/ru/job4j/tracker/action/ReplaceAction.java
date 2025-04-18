package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.Output;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("\n=== Редактирование заявки ===");
        int id = input.askInt("Ведите id заявки: ");
        String name = input.askStr("Введите новое имя заявки: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println(GREEN + "Заявка изменена успешно." + RESET);
        } else {
            output.println(RED + "\n\tОшибка замены заявки." + RESET);
        }
        return true;
    }
}
