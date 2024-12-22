package ru.job4j.tracker.input;

/**
 * Класс MockInput реализует интерфейс Input
 * и используется для симуляции ввода данных в тестах,
 * чтобы имитировать консольный ввод.
 * <p>
 * Этот класс позволяет задавать заранее определенные ответы, которые
 * будут возвращаться при вызове методов askStr и askInt.
 * </p>
 * String[] answers - поле с вариантами ответов пользователя.
 * int position = 0 - счетчик, чтобы при повторном вызове метода askStr
 * мы получали следующую ячейку из нашего массива.
 */
public class MockInput implements Input {
    private final String[] answers;
    private int position = 0;

    public MockInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
