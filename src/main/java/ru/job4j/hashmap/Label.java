package ru.job4j.hashmap;

public record Label(String name, double score) implements Comparable<Label> {

    @Override
    public int compareTo(Label obj) {
        return Double.compare(score, obj.score);
    }
}
