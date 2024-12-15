package ru.job4j.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    private static final float DELTA = 0.01F;

    @Test
    void when00to20then2() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        double expected = 2;
        Point first = new Point(x1, y1);
        Point second = new Point(x2, y2);
        double actual = first.distance(second);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void when00toMinus30then3() {
        int x1 = 0;
        int y1 = 0;
        int x2 = -3;
        int y2 = 0;
        double expected = 3;
        Point first = new Point(x1, y1);
        Point second = new Point(x2, y2);
        double actual = first.distance(second);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void when50to00then5() {
        int x1 = 5;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        double expected = 5;
        Point first = new Point(x1, y1);
        Point second = new Point(x2, y2);
        double actual = first.distance(second);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void when01to00then1() {
        int x1 = 0;
        int y1 = 1;
        int x2 = 0;
        int y2 = 0;
        double expected = 1;
        Point first = new Point(x1, y1);
        Point second = new Point(x2, y2);
        double actual = first.distance(second);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void whenMinus10to03then4Dot47() {
        int x1 = -2;
        int y1 = 0;
        int x2 = 0;
        int y2 = 4;
        double expected = 4.47;
        Point first = new Point(x1, y1);
        Point second = new Point(x2, y2);
        double actual = first.distance(second);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("Проверка расстояния между одной и той же точкой (ожидается 0)")
    void whenDistance3dSamePoint() {
        Point point1 = new Point(1, 2, 3);
        Point point2 = new Point(1, 2, 3);
        double expected = 0;
        double actual = point1.distance3d(point2);
        assertThat(actual).isCloseTo(expected, within(0.01));
    }

    @Test
    @DisplayName("Проверка расстояния между двумя разными точками в трехмерном пространстве")
    void whenDistance3dDifferentPoints() {
        Point point1 = new Point(1, 2, 3);
        Point point2 = new Point(4, 6, 8);
        double expected = 7.07;
        double actual = point1.distance3d(point2);
        assertThat(actual).isCloseTo(expected, within(0.01));
    }

    @Test
    @DisplayName("Проверка расстояния между точками с отрицательными координатами")
    void whenDistance3dNegativeCoordinates() {
        Point point1 = new Point(-1, -2, -3);
        Point point2 = new Point(-4, -6, -8);
        double expected = 7.07;
        double actual = point1.distance3d(point2);
        assertThat(actual).isCloseTo(expected, within(0.01));
    }

    @Test
    @DisplayName("Проверка расстояния между точками с нулевыми и положительными координатами")
    void whenDistance3dMixedCoordinates() {
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(3, 4, 5);
        double expected = 7.07;
        double actual = point1.distance3d(point2);
        assertThat(actual).isCloseTo(expected, within(0.01));
    }

    @Test
    @DisplayName("Проверка расстояния между точками, отличающимися только по одной оси")
    void whenDistance3dSingleAxisDifference() {
        Point point1 = new Point(1, 1, 1);
        Point point2 = new Point(1, 1, 5);
        double expected = 4;
        double actual = point1.distance3d(point2);
        assertThat(actual).isCloseTo(expected, within(0.01));
    }
}
