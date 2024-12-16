package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Статус Toyota: " + toyota.info());
        System.out.println("Статус Volvo: " + volvo.info());

        Status[] values = Status.values();
        for (Status status : values) {
            System.out.printf("""
                    {
                        Название статуса: %s,
                        Порядковый номер статуса: %s
                    }%n""", status.name(), status.ordinal());
        }
    }
}
