package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    @DisplayName("Проверка, что пользователь старше 18 лет может водить")
    void testCanDriveWhenAgeIs18OrAbove() {
        User user = new User("John", 18);
        assertThat(user.canDrive()).isTrue();
    }

    @Test
    @DisplayName("Проверка, что пользователь младше 18 лет не может водить")
    void testCanDriveWhenAgeIsBelow18() {
        User user = new User("Alice", 17);
        assertThat(user.canDrive()).isFalse();
    }

    @Test
    @DisplayName("Проверка, что пользователь ровно 18 лет может водить")
    void testCanDriveWhenAgeIsExactly18() {
        User user = new User("Bob", 18);
        assertThat(user.canDrive()).isTrue();
    }

    @Test
    @DisplayName("Проверка, что пользователь старше 18 лет может водить")
    void testCanDriveWhenAgeIsAbove18() {
        User user = new User("Charlie", 25);
        assertThat(user.canDrive()).isTrue();
    }

    @Test
    @DisplayName("Проверка, что пользователь младше 18 лет не может водить")
    void testCanDriveWhenAgeIsBelow18Boundary() {
        User user = new User("Diana", 16);
        assertThat(user.canDrive()).isFalse();
    }
}
