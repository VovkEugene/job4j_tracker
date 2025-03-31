package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    public void whenSortDescendingThenSortedCorrectly() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Banana"));
        items.add(new Item("Apple"));
        items.add(new Item("Cherry"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Cherry"));
        expected.add(new Item("Banana"));
        expected.add(new Item("Apple"));

        items.sort(new ItemDescByName());

        assertThat(items)
                .usingRecursiveComparison()
                .ignoringFields("created")
                .isEqualTo(expected);
    }
}