package ru.job4j.oop;

/**
 * Использование метода feedPet демонстрирует, как можно передавать объекты в методы
 * и вызывать их методы внутри других методов, что является важной концепцией в ООП
 */
public class Tamagotchi {
    private int weight = 100;

    public void feed() {
        weight += 10;
    }

    public String info() {
        return "weight: " + weight;
    }

    public static void feedPet(Tamagotchi petCopy) {
        petCopy.feed();
    }

    public static void main(String[] args) {
        Tamagotchi pet = new Tamagotchi();
        System.out.println(pet.info());
        feedPet(pet);
        System.out.println(pet.info());
    }
}
