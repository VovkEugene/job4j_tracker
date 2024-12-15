package ru.job4j.oop;

/**
 * Effective final переменная - это переменная,
 * которая никогда не меняется после её инициализации.
 * Её запись в программе выглядела бы как запись обычной переменной.
 * Главное условие, что она не должна меняться после инициализации.
 * Локальные классы содержат ссылку на внешний класс только в нестатическом контексте,
 * подобно обычным внутренним классам.
 */
public class Local {
    private final String name = "Petr";

    public void getFullName() {
        final String surname = "Arsentev";

        class FullName {
            public void printFullName() {
                System.out.println(name + " " + surname);
            }
        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static void main(String[] args) {
        Local local = new Local();
        local.getFullName();
    }
}
