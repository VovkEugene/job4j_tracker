package ru.job4j.condition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {

    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int x;

    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private int y;

    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private int z;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     *
     * @param first  координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Конструктор, который принимает начальное состояние
     * объекта "точка" в трехмерном пространстве
     *
     * @param first  координата x
     * @param second координата y
     * @param third  координата z
     */
    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public void info() {
        System.out.println("Point[" + this.x + ", " + this.y + "]");
    }

    public double distance3d(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2)
                + Math.pow(this.y - that.y, 2)
                + Math.pow(this.z - that.z, 2));
    }
}
