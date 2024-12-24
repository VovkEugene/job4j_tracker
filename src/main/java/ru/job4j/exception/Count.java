package ru.job4j.exception;

/**
 * Популярные исключения:
 * java.lang.IllegalArgumentException - метод вызывается с некорректными параметрами.
 * java.lang.IllegalStateException - метод вызывается с объекта в не корректном состоянии.
 * java.lang.NullPointerException - методы вызывается у переменной, которая инициализирована null ссылкой.
 */
public class Count {
    public static int add(int start, int finish) {
        if (start > finish) {
            throw new IllegalArgumentException("Start should be less than finish");
        }
        int result = 0;
        for (int i = start; i != finish; i++) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Sum of 20 to 10 is : " + add(20, 10));
    }
}
