package ru.job4j.io;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("I am the great Oracle. What do you want to know? ");
        String line = scanner.nextLine();
        while (!Objects.equals(line, "")) {
            magic();
            Thread.sleep(1000);
            System.out.print("What do you still want to know? ");
            line = scanner.nextLine();
        }
    }

    private static void magic() {
        int digit = new Random().nextInt(3);
        switch (digit) {
            case 0 -> System.out.println("Yes");
            case 1 -> System.out.println("No");
            default -> System.out.println("Maybe");
        }
    }
}
