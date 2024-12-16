package ru.job4j.inheritance;

public class IceCreamPlusJamPlusNuts extends IceCreamPlusJam {
    private static final int NUTS_PRICE = 25;

    public IceCreamPlusJamPlusNuts(int weight) {
        super(weight);
    }

    @Override
    public int price() {
        return NUTS_PRICE + super.price();
    }
}
