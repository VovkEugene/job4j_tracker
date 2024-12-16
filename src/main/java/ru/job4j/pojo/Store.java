package ru.job4j.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);
        Product[] products = new Product[5];
        products[0] = milk;
        products[1] = bread;
        products[2] = egg;
        showInfo(products);

        System.out.println("Replace milk to oil.");
        Product oil = new Product("Oil", 11);
        products[0] = oil;
        showInfo(products);

        showInfoWhenCountMore10(products);
    }

    private static void showInfo(Product[] products) {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + " - " + product.getCount());
            }
        }
    }

    private static void showInfoWhenCountMore10(Product[] products) {
        System.out.println("Shown only product.count > 10");
        for (Product product : products) {
            if (product != null && product.getCount() > 10) {
                System.out.println(product.getName() + " - " + product.getCount());
            }
        }
    }
}
