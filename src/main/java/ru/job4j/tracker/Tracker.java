package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Хранилище для заданий
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int nextId = 1;

    /**
     * Добавление заявки
     */
    public Item add(Item item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    /**
     * Вывод всех заявок
     */
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    /**
     * Вывод заявки по id
     */
    public Item findById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Вывод заявок по имени
     */
    public List<Item> findByName(String key) {
        return items.stream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());
    }

    /**
     * Изменение заявки
     */
    public boolean replace(int id, Item item) {
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                item.setId(id);
                items.set(index, item);
                return true;
            }
        }
        return false;
    }

    /**
     * Удаление заявки
     */
    public void delete(int id) {
        items.removeIf(item -> item.getId() == id);
    }
}
