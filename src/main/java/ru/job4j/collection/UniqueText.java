package ru.job4j.collection;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueText {

    public boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> check = Arrays.stream(origin)
                .collect(Collectors.toSet());
        for (String word : text) {
            if (!check.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
