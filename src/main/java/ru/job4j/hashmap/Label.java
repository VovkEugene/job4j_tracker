package ru.job4j.hashmap;

/*
Класс Label содержит результаты: имя и баллы.
Этот класс используется как для учеников, так и для предметов.
 */
public record Label(String name, double score) implements Comparable<Label> {

    @Override
    public int compareTo(Label obj) {
        return Double.compare(score, obj.score);
    }
}
