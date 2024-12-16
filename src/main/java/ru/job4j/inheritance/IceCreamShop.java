package ru.job4j.inheritance;

public class IceCreamShop {
    public static void main(String[] args) {
        IceCream iceCream = new IceCreamPlusJam(150);
        IceCream iceCreamPlus = new IceCreamPlusJamPlusNuts(150);
        System.out.println(iceCream.price());
        System.out.println(iceCreamPlus.price());
    }
}
