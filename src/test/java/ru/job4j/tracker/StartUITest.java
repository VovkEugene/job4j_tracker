package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindAllAction;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.action.ReplaceAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.MockOutput;
import ru.job4j.tracker.output.Output;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.tracker.action.UserAction.GREEN;
import static ru.job4j.tracker.action.UserAction.RESET;

class StartUITest {
    private static final String TASK_NAME = "fix bug";
    private static final String NEW_TASK_NAME = "add feature";

    private Tracker tracker;
    private Input input;
    private Item item;
    private Output output;

    @BeforeEach
    public void setUp() {
        tracker = new Tracker();
        item = new Item(TASK_NAME);
        output = new ConsoleOutput();
    }

    @Test
    @DisplayName("Тест проверяет, что метод добавляет новую заявку в Tracker")
    void whenAddItem() throws InterruptedException {
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        String[] answers = {"0", TASK_NAME, "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item actual = tracker.findAll()[0];
        Item expected = new Item(TASK_NAME);
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    @DisplayName("Тест проверяет, что метод находит заявки по имени.")
    void whenFindItemByName() throws InterruptedException {
        UserAction[] actions = {new FindByNameAction(output), new ExitAction(output)};
        String[] answers = {"0", TASK_NAME, "1"};
        input = new MockInput(answers);
        tracker.add(new Item(TASK_NAME));
        tracker.add(new Item(NEW_TASK_NAME));
        tracker.add(new Item(TASK_NAME));
        new StartUI(output).init(input, tracker, actions);
        Item[] actual = tracker.findByName(TASK_NAME);
        assertThat(actual).hasSize(2);
    }

    @Test
    @DisplayName("Тест проверяет, что метод находит заявку по id.")
    void whenFindItemById() throws InterruptedException {
        UserAction[] actions = {new FindByIdAction(output), new ExitAction(output)};
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item actual = tracker.findById(1);
        assertThat(actual).isEqualTo(item);
    }

    @Test
    @DisplayName("Тест проверяет, что метод удаляет заявку по id.")
    void whenDeleteItem() throws InterruptedException {
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item actual = tracker.findById(1);
        assertThat(actual).isNull();
    }

    @Test
    @DisplayName("Тест проверяет, что метод заменяет заявку по id.")
    void whenReplaceItem() throws InterruptedException {
        UserAction[] actions = {new ReplaceAction(output), new ExitAction(output)};
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), NEW_TASK_NAME, "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item actual = tracker.findById(item.getId());
        assertThat(actual.getName()).isEqualTo(NEW_TASK_NAME);
    }

    @Test
    @DisplayName("Тест проверяет, что метод выводит все заявки.")
    void whenFindAllItems() throws InterruptedException {
        UserAction[] actions = {new FindAllAction(output), new ExitAction(output)};
        tracker.add(item);
        tracker.add(new Item(NEW_TASK_NAME));
        String[] answers = {"0", "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item[] actual = tracker.findAll();
        assertThat(actual).hasSize(2);
    }

    @Test
    @DisplayName("Тест проверяет, что метод выводит сообщение об ошибке, если заявка не найдена.")
    void whenFindItemByIdNotFound() throws InterruptedException {
        UserAction[] actions = {new FindByIdAction(output), new ExitAction(output)};
        String[] answers = {"0", "999", "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item actual = tracker.findById(999);
        assertThat(actual).isNull();
    }

    @Test
    @DisplayName("Тест проверяет, что метод выводит сообщение об ошибке, если заявка не найдена.")
    void whenDeleteItemNotFound() throws InterruptedException {
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        String[] answers = {"0", "999", "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item actual = tracker.findById(999);
        assertThat(actual).isNull();
    }


    @Test
    @DisplayName("Тест проверяет, что метод выводит сообщение об ошибке, если заявка не найдена.")
    void whenReplaceItemNotFound() throws InterruptedException {
        UserAction[] actions = {new ReplaceAction(output), new ExitAction(output)};
        String[] answers = {"0", "999", NEW_TASK_NAME, "1"};
        input = new MockInput(answers);
        new StartUI(output).init(input, tracker, actions);
        Item actual = tracker.findById(999);
        assertThat(actual).isNull();
    }

    @Test
    @DisplayName("Тест проверяет вывод меню для ReplaceAction.")
    public void whenReplaceItemTestOutputIsSuccessfully() throws InterruptedException {
        output = new MockOutput();
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), NEW_TASK_NAME, "1"};
        input = new MockInput(answers);
        UserAction[] actions = {new ReplaceAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "\nМеню:" + lineSeparator()
                        + "0. Изменить заявку" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Редактирование заявки ===" + lineSeparator()
                        + GREEN + "Заявка изменена успешно." + RESET + lineSeparator()
                        + "\nМеню:" + lineSeparator()
                        + "0. Изменить заявку" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Завершение программы ===" + lineSeparator());
    }

    @Test
    @DisplayName("Тест проверяет вывод меню для FindAllAction.")
    public void whenFindAllActionTestOutputIsSuccessfully() throws InterruptedException {
        output = new MockOutput();
        tracker.add(item);
        input = new MockInput(new String[]{"0", "1"});
        UserAction[] actions = {new FindAllAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "\nМеню:" + lineSeparator()
                        + "0. Показать все заявки" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Вывод всех заявок ===" + lineSeparator()
                        + item + lineSeparator()
                        + "\nМеню:" + lineSeparator()
                        + "0. Показать все заявки" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Завершение программы ===" + lineSeparator());
    }

    @Test
    @DisplayName("Тест проверяет вывод меню для FindByIdAction.")
    public void whenFindByIdActionTestOutputIsSuccessfully() throws InterruptedException {
        output = new MockOutput();
        tracker.add(item);
        input = new MockInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new FindByIdAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "\nМеню:" + lineSeparator()
                        + "0. Показать заявку по id" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Вывод заявки по id ===" + lineSeparator()
                        + item + lineSeparator()
                        + "\nМеню:" + lineSeparator()
                        + "0. Показать заявку по id" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Завершение программы ===" + lineSeparator());
    }

    @Test
    @DisplayName("Тест проверяет вывод меню для FindByNameAction.")
    public void whenFindByNameActionTestOutputIsSuccessfully() throws InterruptedException {
        output = new MockOutput();
        tracker.add(item);
        input = new MockInput(new String[]{"0", TASK_NAME, "1"});
        UserAction[] actions = {new FindByNameAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "\nМеню:" + lineSeparator()
                        + "0. Показать заявки по имени" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Вывод заявки по имени ===" + lineSeparator()
                        + item + lineSeparator()
                        + "\nМеню:" + lineSeparator()
                        + "0. Показать заявки по имени" + lineSeparator()
                        + "1. Завершить программу" + lineSeparator()
                        + "\n=== Завершение программы ===" + lineSeparator());
    }

    @Test
    @DisplayName("Тест проверяет вывод меню для ExitAction.")
    public void whenExit() throws InterruptedException {
        output = new MockOutput();
        input = new MockInput(new String[]{"0"});
        UserAction[] actions = {new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "\nМеню:" + lineSeparator()
                        + "0. Завершить программу" + lineSeparator()
                        + "\n=== Завершение программы ===" + lineSeparator());
    }
}