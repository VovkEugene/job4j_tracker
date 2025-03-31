package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {

    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User another) {
        return this.name.compareTo(another.name) == 0
                ? Integer.compare(this.age, another.age)
                : this.name.compareTo(another.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
