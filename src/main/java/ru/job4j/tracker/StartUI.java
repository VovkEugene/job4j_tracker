package ru.job4j.tracker;

import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindAllAction;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.ReplaceAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import static ru.job4j.tracker.action.UserAction.RED;
import static ru.job4j.tracker.action.UserAction.RESET;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    /**
     * Метод инициализирует приложение
     * и запускает выполнение различных пользовательских действий
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) throws InterruptedException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.length) {
                output.println(
                        RED + "\n\tНеверный ввод, вы можете выбрать: от 0 до " + (actions.length - 1) + RESET);
                Thread.sleep(1000);
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);

        }
    }

    /**
     * Метод выводит на экран меню доступных пользовательских действий
     */
    private void showMenu(UserAction[] actions) {
        output.println("\nМеню:");
        for (int i = 0; i < actions.length; i++) {
            output.println(i + ". " + actions[i].name());
        }
    }

    /**
     * Метод запускает наше приложение
     */
    public static void main(String[] args) throws InterruptedException {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), output);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
