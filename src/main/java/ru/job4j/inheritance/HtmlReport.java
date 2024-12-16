package ru.job4j.inheritance;

public class HtmlReport extends TextReport {

    @Override
    public String generate(String title, String body) {
        return String.format("""
                <h2>%s</h2>
                <p>%s</p>
                """, title, body);
    }
}
