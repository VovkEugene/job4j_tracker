package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int length = products.length;
        for (int i = 0; i < length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
