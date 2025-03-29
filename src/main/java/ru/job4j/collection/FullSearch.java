package ru.job4j.collection;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        return tasks.stream()
                .map(Task::getNumber)
                .collect(Collectors.toSet());
    }
}
