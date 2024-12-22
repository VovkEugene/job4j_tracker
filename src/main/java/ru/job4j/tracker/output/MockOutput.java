package ru.job4j.tracker.output;

public class MockOutput implements Output {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void println(Object object) {
        if (object != null) {
            sb.append(object);
        } else {
            sb.append("null");
        }
        sb.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
