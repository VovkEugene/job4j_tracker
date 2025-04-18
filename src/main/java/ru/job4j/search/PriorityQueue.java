package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private final LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task item : tasks) {
            if (task.getPriority() < item.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    /**
     * Метод возвращает первый элемент из списка и удаляет его
     */
    public Task take() {
        return tasks.poll();
    }
}
