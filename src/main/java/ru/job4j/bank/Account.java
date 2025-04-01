package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, описывающий банковский счёт.
 * <p>
 * Содержит реквизиты счёта и баланс.
 * Считается, что два счёта равны, если у них совпадают реквизиты.
 * </p>
 *
 * @author Eugene Vovk
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счёта.
     */
    private String requisite;
    /**
     * Баланс счёта.
     */
    private double balance;

    /**
     * Конструктор для создания счета с заданными реквизитами и балансом.
     *
     * @param requisite реквизиты счёта
     * @param balance   начальный баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счета.
     *
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты счета.
     *
     * @param requisite новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает баланс счета.
     *
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счета.
     *
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает два счета. Счета считаются равными, если их реквизиты совпадают.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хеш-код счета на основе его реквизитов.
     *
     * @return хеш-код счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
