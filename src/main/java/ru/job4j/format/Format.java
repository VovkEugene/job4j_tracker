package ru.job4j.format;

import java.time.LocalDateTime;

/**
 * Задают вид даты и времени здесь спецификаторы %t с флагами F и T.
 * Флаг F выводит дату в формате ISO 8601 - ГГГГ-ММ-ДД,
 * а флаг T выводит время в формате ЧЧ:ММ:СС.
 */
public class Format {
    public static String getGreeting(String name, int age, double salary) {
        LocalDateTime time = LocalDateTime.now();
        return String.format("""
                Привет! Я %s, мой возраст: %d, мой заработок $%.2f
                Текущая дата: %tF
                Текущее время: %tT
                """, name, age, salary, time, time);
    }

    public static void main(String[] args) {
        System.out.println(getGreeting("Александра", 23, 1550));
    }
}
