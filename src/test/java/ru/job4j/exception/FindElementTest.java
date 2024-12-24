package ru.job4j.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static ru.job4j.exception.FindElement.indexOf;

class FindElementTest {

    @Test
    void whenElementExistsThenReturnIndex() throws ElementNotFoundException {
        String[] array = {"one", "two", "R"};
        int index = indexOf(array, "two");
        assertThat(index).isEqualTo(1);
    }

    @Test
    void whenSearchingForNullInArrayWithNullThenReturnIndex() throws ElementNotFoundException {
        String[] array = {"one", null, "three"};
        int index = indexOf(array, null);
        assertThat(index).isEqualTo(1);
    }

    @Test
    void whenElementDoesNotExistThenThrowException() {
        String[] array = {"one", "two", "three"};
        assertThatThrownBy(() -> indexOf(array, "six"))
                .isInstanceOf(ElementNotFoundException.class)
                .hasMessage("No element in the array");
    }

    @Test
    void whenArrayIsEmptyThenThrowException() {
        String[] array = {};
        assertThatThrownBy(() -> indexOf(array, "one"))
                .isInstanceOf(ElementNotFoundException.class)
                .hasMessage("No element in the array");
    }

    @Test
    void whenSearchingForNullInArrayWithoutNullThenThrowException() {
        String[] array = {"one", "two", "three"};
        assertThatThrownBy(() -> indexOf(array, null))
                .isInstanceOf(ElementNotFoundException.class)
                .hasMessage("No element in the array");
    }
}