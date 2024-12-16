package ru.job4j.concat;

import java.util.StringJoiner;

public class ConcatTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Job4j");
        for (int index = 0; index < 9999; index++) {
            sb.append(index);
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("abc").add("def").add("ghi");
        System.out.println(stringJoiner);
        String joined = stringJoiner.toString();
        System.out.println(joined);
    }
}
