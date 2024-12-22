package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("\n=== Удаление заявки ===");
        int id = input.askInt("Ведите id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(id);
            output.println(GREEN + "Заявка удалена успешно." + RESET);
        } else {
            output.println(RED + "\n\tОшибка удаления заявки." + RESET);
        }
        return true;
    }
}
