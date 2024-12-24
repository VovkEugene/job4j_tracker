package ru.job4j.exception;

import java.util.Objects;

public class FindElement {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int length = value.length;
        for (int i = 0; i < length; i++) {
            if (Objects.equals(value[i], key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("No element in the array");
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String abuse : abuses) {
            if (abuse != null && abuse.contains(value)) {
                throw new ElementAbuseException("Forbidden value");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] array = {"one", "two", null, "three"};
        try {
            indexOf(array, null);
            sent("three", array);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
