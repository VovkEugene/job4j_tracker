package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.keySet().removeIf(user -> Objects.equals(user.getPassport(), passport));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> Objects.equals(user.getPassport(), passport))
                .findFirst()
                .orElse(null);
    }

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

    public List<Account> getAccounts(User user) {
        return users.getOrDefault(user, emptyList());
    }
}
