package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("john.doe@example.com", "John Doe");
        map.put("jane.smith@example.com", "Jane Smith");
        map.put("alice.brown@example.com", "Alice Brown");
        map.put("bob.johnson@example.com", "Bob Johnson");
        map.put("carol.white@example.com", "Carol White");

        for (String key : map.keySet()) {
            System.out.printf("%s\t- %s\n", key, map.get(key));
        }
    }
}
