package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now(zone);
        LocalDateTime currentDateTime = LocalDateTime.now(zone);
        System.out.println("Текущая дата: " + currentDate);
        System.out.println("Текущее время: " + currentTime);
        System.out.println("Текущие дата и время до форматирования: " + currentDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
    }
}
