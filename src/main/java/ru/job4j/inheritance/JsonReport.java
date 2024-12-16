package ru.job4j.inheritance;

public class JsonReport extends TextReport {

    @Override
    public String generate(String title, String body) {
        return String.format("""
                {
                    "title" : "%s",
                    "body" : "%s"
                }""", title, body);
    }
}
