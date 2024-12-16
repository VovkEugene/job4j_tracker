package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {

    @Test
    @DisplayName("Тест поиска элемента по ID")
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    @DisplayName("Тест поиска всех элементов")
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll()[0];
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    @DisplayName("Тест поиска всех элементов")
    public void whenFindAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item[] actual = tracker.findAll();
        assertThat(actual).containsExactly(first, second);
    }

    @Test
    @DisplayName("Тест поиска элементов по имени (проверка длины массива)")
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(first.getName());
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    @DisplayName("Тест поиска элементов по имени (проверка имени второго элемента)")
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(second.getName());
        assertThat(result[1].getName()).isEqualTo(second.getName());
    }

    @Test
    @DisplayName("Тест добавления элемента")
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("bug");
        tracker.add(item);
        Item[] actual = tracker.findAll();
        assertThat(actual).containsExactly(item);
        assertThat(item.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Тест поиска элементов по несуществующему имени")
    public void whenFindByNameNonExistentThenReturnEmptyArray() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        Item[] actual = tracker.findByName("second");
        assertThat(actual).isEmpty();
    }

    @Test
    @DisplayName("Тест поиска элемента по несуществующему ID")
    public void whenFindByIdNonExistentThenReturnNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        Item actual = tracker.findById(999);
        assertThat(actual).isNull();
    }

    @Test
    @DisplayName("Тест поиска элементов по имени")
    public void whenFindByNameThenReturnItemsWithSameName() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        Item second = new Item("first");
        Item other = new Item("other");
        tracker.add(first);
        tracker.add(second);
        tracker.add(other);
        Item[] actual = tracker.findByName("first");
        assertThat(actual).containsExactly(first, second);
    }

    @Test
    @DisplayName("Тест замены элемента")
    public void whenReplaceItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        Item updateItem = new Item("Bug with description");
        tracker.add(item);
        int id = item.getId();
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    @DisplayName("Тест замены несуществующего элемента")
    public void whenReplaceItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Тест удаления элемента")
    public void whenDeleteItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    @DisplayName("Тест удаления элемента по id")
    public void whenDeleteById0FromArrayOf2Elements() {
        Tracker tracker = new Tracker();
        Item first = new Item("Bug");
        Item second = new Item("Feature");
        tracker.add(first);
        tracker.add(second);
        int id = first.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    @DisplayName("Тест удаления элемента по несуществующему ID")
    public void whenDeleteItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        tracker.delete(1000);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
    }
}