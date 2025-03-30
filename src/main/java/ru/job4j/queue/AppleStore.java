package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String name = "";
        for (int i = 0; i < count; i++) {
            name = queue.poll().name();
        }
        return name;
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }
}
