package ru.job4j.queue;

import java.util.Comparator;

public class TransactionSortDescByAmount implements Comparator<Transaction> {
    @Override
    public int compare(Transaction first, Transaction second) {
        return Integer.compare(second.getAmount(), first.getAmount());
    }
}
