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
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

public class StartUI {
    private static final String MESSAGE_ERROR =
            "\n\tНужно ввести число от 0 до 6, что соответствует операциям в меню. ";
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
            try {
                showMenu(actions);
                int select = input.askInt("Выбрать: ");
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.err.println(MESSAGE_ERROR + exception.getMessage());
                Thread.sleep(1000);
            }
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
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
