package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        int length = products.length - 1;
        for (int i = index; i < length; i++) {
            products[i] = products[i + 1];
        }
        products[length] = null;
        return products;
    }
}
