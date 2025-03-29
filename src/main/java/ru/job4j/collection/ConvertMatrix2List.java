package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Как вариант:
 * public List<Integer> toList(int[][] array) {
 *     return Arrays.stream(array)
 *             .flatMapToInt(Arrays::stream)
 *             .boxed()
 *             .collect(Collectors.toList());
 * }
 */
public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
