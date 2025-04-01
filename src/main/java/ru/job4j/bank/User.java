package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, описывающий пользователя банковской системы.
 * <p>
 * Пользователь характеризуется паспортными данными и именем.
 * Два пользователя считаются равными, если у них совпадают паспортные данные.
 * </p>
 *
 * @author Eugene Vovk
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор для создания пользователя с заданными паспортными данными и именем.
     *
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает паспорт пользователя.
     *
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает паспорт пользователя.
     *
     * @param passport новый паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     *
     * @param username новое имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает двух пользователей. Пользователи считаются равными, если их паспортные данные совпадают.
     *
     * @param o другой объект для сравнения
     * @return {@code true}, если объекты равны, иначе {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хеш-код пользователя на основе его паспортных данных.
     *
     * @return хеш-код пользователя
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
