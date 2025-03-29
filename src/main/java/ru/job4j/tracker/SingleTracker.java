package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private static volatile SingleTracker instance;

    private final Tracker tracker;

    private SingleTracker() {
        tracker = new Tracker();
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            synchronized (SingleTracker.class) {
                if (instance == null) {
                    instance = new SingleTracker();
                }
            }
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}
