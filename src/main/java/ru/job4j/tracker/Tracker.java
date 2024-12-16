package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

/**
 * Хранилище для заданий
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return null;
        }
        return items[index];
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i].getName(), key)) {
                result[counter++] = items[i];
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items[index] = item;
        return true;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
    }

    private int indexOf(int id) {
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
