package ru.job4j.polymorphism;

public class FileStore implements Store {
    private String path;

    public FileStore() {
    }

    public FileStore(String path) {
        this.path = path;
    }

    @Override
    public void save(String data) {
    }

    @Override
    public String read() {
        return null;
    }
}
