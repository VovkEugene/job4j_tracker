package ru.job4j.tracker;

import java.util.Arrays;

public class DropArray {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        String[] result = new String[names.length];
        int size = 0;
        for (String name : names) {
            if (name != null) {
                result[size] = name;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        print(result);

        names = new String[]{"Petr", null, "Ivan", "Stepan", "Fedor"};
        System.arraycopy(names, 2, names, 1, 3);
        print(names);
    }

    private static void print(String[] array) {
        for (String item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
