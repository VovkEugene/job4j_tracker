package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Collections.emptyList;

/**
 * Класс реализует сервис для управления банковскими операциями:
 * <ul>
 *     <li>Добавление/удаление пользователей</li>
 *     <li>Управление банковскими счетами</li>
 *     <li>Поиск пользователей и счетов</li>
 *     <li>Перевод денег между счетами</li>
 * </ul>
 *
 * @author Eugeve Vovk
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их счетов.
     * Ключ - объект User, значение - список счетов {@link Account} этого пользователя.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в банковский сервис.
     * Если пользователь с таким же значением не существует, то создаётся новая запись.
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя по номеру паспорта.
     *
     * @param passport паспорт пользователя, который необходимо удалить
     */
    public void deleteUser(String passport) {
        users.keySet().removeIf(user -> Objects.equals(user.getPassport(), passport));
    }

    /**
     * Добавляет новый счет пользователю, найденному по номеру паспорта.
     * Если счет уже присутствует в списке счетов пользователя, добавление не производится.
     *
     * @param passport номер паспорта пользователя, к которому добавляется счет
     * @param account  счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по номеру паспорта.
     *
     * @param passport номер паспорта пользователя
     * @return найденный пользователь или {@code null}, если пользователь не найден
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> Objects.equals(user.getPassport(), passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Находит счет пользователя по номеру паспорта и реквизиту счета.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизит счета
     * @return найденный счет или {@code null}, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(account -> Objects.equals(account.getRequisite(), requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Осуществляет перевод денежных средств с одного счета на другой.
     * <p>
     * Перевод производится только при условии, что сумма перевода положительна,
     * оба пользователя (источник и получатель) найдены, и у источника достаточно средств.
     * </p>
     *
     * @param sourcePassport       паспорт пользователя-отправителя
     * @param sourceRequisite      реквизит счета отправителя
     * @param destinationPassport  паспорт пользователя-получателя
     * @param destinationRequisite реквизит счета получателя
     * @param amount               сумма перевода
     * @return {@code true}, если перевод выполнен, иначе {@code false}
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        if (amount <= 0) {
            return false;
        }
        User sourceUser = findByPassport(sourcePassport);
        User destinationUser = findByPassport(destinationPassport);
        if (sourceUser == null || destinationUser == null) {
            return false;
        }
        Account sourceAccount = findByRequisite(sourceUser.getPassport(), sourceRequisite);
        Account destinationAccount = findByRequisite(destinationUser.getPassport(), destinationRequisite);
        if (sourceAccount != null && destinationAccount != null) {
            if (sourceAccount.getBalance() >= amount) {
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            }
            return true;
        }
        return false;
    }

    /**
     * Возвращает список счетов, принадлежащих указанному пользователю.
     *
     * @param user пользователь, для которого запрашиваются счета
     * @return список счетов пользователя или пустой список, если пользователь не найден
     */
    public List<Account> getAccounts(User user) {
        return users.getOrDefault(user, emptyList());
    }
}
