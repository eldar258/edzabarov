package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class ru.job4j.bank.
 *
 * @author edzabarov
 * @since 14.09.2017
 */
public class BankMap {
    /**
     * entries value.
     */
    private HashMap<User, List<Account>> entry = new HashMap<>();

    /**
     * add user.
     * @param user -
     */
    public void addUser(User user) {
        if (!this.entry.containsKey(user)) {
            this.entry.put(user, new ArrayList<Account>());
        }
    }
    /**
     * delete user.
     * @param user -
     */
    public void deleteUser(User user) {
        this.entry.remove(user);
    }
    /**
     * addAccountToUser.
     * @param user -
     * @param account -
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> accounts = this.entry.get(user);
        if (accounts != null) {
            accounts.add(account);
        } else {
            accounts = new ArrayList<>();
            accounts.add(account);
            this.entry.put(user, accounts);
        }
    }
    /**
     * deleteAccountFromUser.
     * @param user -
     * @param account -
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accounts = this.entry.get(user);
        if (accounts != null) {
            accounts.remove(account);
        }
    }

    /**
     * getUserAccounts.
     * @param user -
     * @return -
     */
    public List<Account> getUserAccounts(User user) {
        return this.entry.get(user);
    }

    /**
     * get entry. needs from tests.
     * @return -
     */
    public HashMap<User, List<Account>> getEntry() {
        return entry;
    }

    /**
     * transferMoney.
     * @param srcUser - source User
     * @param srcAccount - account's source User
     * @param dstUser - final User
     * @param dstAccount - account's final User
     * @param amount - value of money transfer
     * @return - true if transfer complete
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        List<Account> firstAccounts =  this.entry.get(srcUser);
        List<Account> secondAccounts =  this.entry.get(dstUser);
        int indexFirsAccount = firstAccounts.indexOf(srcAccount);
        int indexSecondAccount = secondAccounts.indexOf(dstAccount);
        boolean result = (indexFirsAccount >= 0 && indexSecondAccount >= 0) && (srcAccount.getValue() >= amount); //лож, если какого-то из аккаунтов не существует или у первого аккаунта недостаточно средств
        if (result) {
            firstAccounts.get(indexFirsAccount).changeValue(-amount);
            secondAccounts.get(indexSecondAccount).changeValue(amount);
        }
        return result;
    }
}
