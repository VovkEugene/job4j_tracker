package ru.job4j.pojo;

import java.time.LocalDate;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Petr Arsentev");
        license.setModel("Toyota");
        license.setCode("xx111x");
        license.setCreated(LocalDate.now());

        System.out.println(license.getOwner()
                + " has a car - " + license.getModel()
                + " : " + license.getCode());
    }
}
