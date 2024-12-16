package ru.job4j.enumeration;

/**
 * Enum - это класс c ограниченным набором объектов. Вы можете встретить термин "класс-перечислений".
 * Так как enum - это обычный Java класс, то в нем можно объявить: конструкторы, поля и методы.
 * Перечисление может реализовывать интерфейсы.
 * Enum нельзя объявить абстрактным, потому что у нас нет возможности его наследовать.
 * Однако, мы можем объявить абстрактные методы.
 * Полезные методы класса Enum:
 * - name() - возвращает имя константы (значения) в том же виде, в каком оно объявлено.
 * - ordinal() - возвращает порядковый номер константы (значения),
 * по которому её экземпляр находится в перечислении (нумерация с нуля).
 * - values() - возвращает массив всех элементов перечисления.
 * Если в классе Status нет такого значения (константы),
 * то будет выброшено исключение IllegalArgumentException.
 * Имя константы должно полностью совпадать, включая регистр.
 */
public enum Status implements Code {
    ACCEPTED(1, "Принят") {
        @Override
        public String getMessage() {
            return "Автомобиль принят на СТО";
        }
    },
    IN_WORK(2, "В работе") {
        @Override
        public String getMessage() {
            return "Автомобиль в работе";
        }
    },
    WAITING(3, "Ожидание") {
        @Override
        public String getMessage() {
            return "Автомобиль ожидает запчасти";
        }
    },
    FINISHED(4, "Работы завершены") {
        @Override
        public String getMessage() {
            return "Все работы завершены";
        }
    };

    private final String text;
    private final int code;

    Status(int code, String text) {
        this.text = text;
        this.code = code;
    }

    public String info() {
        return text;
    }

    @Override
    public int code() {
        return code;
    }

    public abstract String getMessage();
}
