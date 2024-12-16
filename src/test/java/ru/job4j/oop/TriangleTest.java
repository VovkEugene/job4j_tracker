package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double actual = triangle.area();
        double expected = 8;
        assertThat(actual).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00and10and01Then0Dot5() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        Triangle triangle = new Triangle(a, b, c);
        double actual = triangle.area();
        double expected = 0.5;
        assertThat(actual).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00and20and02Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(0, 2);
        Triangle triangle = new Triangle(a, b, c);
        double actual = triangle.area();
        double expected = 2;
        assertThat(actual).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00and00and00ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(0, 0);
        Triangle triangle = new Triangle(a, b, c);
        double actual = triangle.area();
        double expected = -1;
        assertThat(actual).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00and10and10ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 0);
        Triangle triangle = new Triangle(a, b, c);
        double actual = triangle.area();
        double expected = -1;
        assertThat(actual).isCloseTo(expected, offset(0.001));
    }
}
