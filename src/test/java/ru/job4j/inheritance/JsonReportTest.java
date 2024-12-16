package ru.job4j.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JsonReportTest {

    @Test
    @DisplayName("Проверка генерации JSON с корректными данными")
    public void whenNameIsDavidBodyIsNameSong() {
        JsonReport jsonReport = new JsonReport();
        String title = "David Gilmour";
        String body = "Shine On You Crazy Diamond";

        String actual = jsonReport.generate(title, body);

        String expected = """
                {
                    "title" : "David Gilmour",
                    "body" : "Shine On You Crazy Diamond"
                }""";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка генерации JSON с корректными данными")
    void whenGenerateWithValidData() {
        JsonReport jsonReport = new JsonReport();
        String title = "Test Title";
        String body = "Test Body";

        String actual = jsonReport.generate(title, body);

        String expected = """
                {
                    "title" : "Test Title",
                    "body" : "Test Body"
                }""";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка генерации JSON с пустыми данными")
    void whenGenerateWithEmptyData() {
        JsonReport jsonReport = new JsonReport();
        String title = "";
        String body = "";

        String actual = jsonReport.generate(title, body);

        String expected = """
                {
                    "title" : "",
                    "body" : ""
                }""";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка генерации JSON с null-значениями")
    void whenGenerateWithNullData() {
        JsonReport jsonReport = new JsonReport();
        String title = null;
        String body = null;

        String actual = jsonReport.generate(title, body);

        String expected = """
                {
                    "title" : "null",
                    "body" : "null"
                }""";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка генерации JSON с длинными данными")
    void whenGenerateWithLongData() {
        JsonReport jsonReport = new JsonReport();
        String title = "This is a very long title that should be whened for JSON generation";
        String body = "This is a very long body that should be whened for JSON generation";

        String actual = jsonReport.generate(title, body);

        String expected = """
                {
                    "title" : "This is a very long title that should be whened for JSON generation",
                    "body" : "This is a very long body that should be whened for JSON generation"
                }""";
        assertThat(actual).isEqualTo(expected);
    }
}