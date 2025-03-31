package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftDigit = left.split("\\.");
        String[] rightDigit = right.split("\\.");
        return Integer.compare(
                Integer.parseInt(leftDigit[0]),
                Integer.parseInt(rightDigit[0]));
    }
}
