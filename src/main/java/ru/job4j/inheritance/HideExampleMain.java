package ru.job4j.inheritance;

/**
 * Статический метод, определенный в дочернем классе,
 * скрывает метод с той же сигнатурой в родительском классе.
 */
public class HideExampleMain {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cat = new Cat();

        animal.instanceInvoke();
        cat.instanceInvoke();

        Animal.staticInvoke();
        Cat.staticInvoke();
    }
}
