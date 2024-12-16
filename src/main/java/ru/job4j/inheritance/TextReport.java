package ru.job4j.inheritance;

public class TextReport {

    public String generate(String title, String body) {
        return title + System.lineSeparator() + body;
    }
}
