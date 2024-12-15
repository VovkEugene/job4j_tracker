package ru.job4j.oop;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean canDrive() {
        return age >= 18;
    }
}
