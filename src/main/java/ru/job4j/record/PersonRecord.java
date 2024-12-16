package ru.job4j.record;

public record PersonRecord(String name, int age) implements Comparable<PersonRecord> {
    public PersonRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не должен быть менее 0");
        }
    }

    @Override
    public int compareTo(PersonRecord o) {
        return name.compareTo(o.name);
    }
}
