package ru.job4j.collection;

import java.util.Set;
import java.util.TreeSet;

import static java.util.Collections.reverseOrder;

public class TreeSort {

    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(reverseOrder());
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        System.out.println(numbers);
    }
}
