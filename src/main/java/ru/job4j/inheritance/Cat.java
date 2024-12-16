package ru.job4j.inheritance;

/**
 * Переопределять можно только нестатические методы,
 * потому что они связаны с объектом и поддерживают полиморфизм.
 *
 * Статические методы можно унаследовать, но нельзя переопределить,
 * так как они связаны с классом и используют статическую привязку.
 */
public class Cat extends Animal {

    @Override
    public void instanceInvoke() {
        System.out.println("Вызов instance-метода экземпляра Cat");
    }

    public static void staticInvoke() {
        System.out.println("Вызов static-метода класса/типа Cat");
    }
}
