package ru.job4j.io;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello my darling! What's your name? ");
        String name = scanner.nextLine();
        System.out.println(name + ", I glad to see you!");
    }
}
