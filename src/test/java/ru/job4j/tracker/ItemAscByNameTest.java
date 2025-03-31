package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void whenSortAscending_thenSortedCorrectly() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Banana"));
        items.add(new Item("Apple"));
        items.add(new Item("Cherry"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Apple"));
        expected.add(new Item("Banana"));
        expected.add(new Item("Cherry"));

        items.sort(new ItemAscByName());

        assertThat(items)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}