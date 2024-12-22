package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Игры.");
            System.out.println("1. Танчики");
            System.out.println("2. Супер Марио");
            System.out.println("3. Выйти");
            System.out.print("Введите пункт меню, чтобы начать игру: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1 -> System.out.println("Супер Марио загружается ... ");
                case 2 -> System.out.println("Танчики загружаются ... ");
                case 3 -> {
                    System.out.println("Игра завершена.");
                    run = false;
                }
                default -> System.out.println("Такой игры нет.");
            }
            System.out.println();
        }
    }
}
