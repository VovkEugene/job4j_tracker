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

    /**
     * Добавление заявки
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Вывод всех заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Вывод заявки по id
     */
    public Item findById(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return null;
        }
        return items[index];
    }

    /**
     * Вывод заявок по имени
     */
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

    /**
     * Изменение заявки
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items[index] = item;
        return true;
    }

    /**
     * Удаление заявки
     */
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
