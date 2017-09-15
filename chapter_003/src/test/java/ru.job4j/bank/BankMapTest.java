package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BankMapTest.
 *
 * @author edzabarov
 * @since 14.09.2017
 */
public class BankMapTest {
    /**
     * addUser.
     */
    @Test
    public void whenAddUserThenUserAdded() {
        BankMap bm = new BankMap();
        User user = new User("123", "name1");
        bm.addUser(user);
        assertThat(bm.getEntry().containsKey(user), is(true));
    }
    /**
     * deleteUser.
     */
    @Test
    public void whenDeleteUserThenUserDeleted() {
        BankMap bm = new BankMap();
        User user = new User("123", "name1");
        bm.addUser(user);
        bm.deleteUser(new User("123", "name1"));
        assertThat(!bm.getEntry().containsKey(user), is(true));
    }
    /**
     * addAccountToUser.
     */
    @Test
    public void whenAddAccountToUserThenUserAccountAdded() {
        BankMap bm = new BankMap();
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 789));
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 555));
        HashMap<User, List<Account>> result = new HashMap<>();
        List<Account> list = new ArrayList<>();
        list.add(new Account(1000, 789));
        list.add(new Account(1000, 555));
        result.put(new User("123", "name1"), list);
        assertThat(bm.getEntry(), is(result));
    }
    /**
     * deleteAccountFromUser.
     */
    @Test
    public void whenDeleteAccountFromUserThenUserAccountDeleted() {
        BankMap bm = new BankMap();
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 789));
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 555));
        HashMap<User, List<Account>> result = new HashMap<>();
        List<Account> list = new ArrayList<>();
        list.add(new Account(1000, 555));
        bm.deleteAccountFromUser(new User("123", "name1"), new Account(1000, 789));
        result.put(new User("123", "name1"), list);
        assertThat(bm.getEntry(), is(result));
    }
    /**
     * getUserAccounts.
     */
    @Test
    public void whenGetUserAccountsThenUserAccountsGeted() {
        BankMap bm = new BankMap();
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 789));
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 555));
        List<Account> result = new ArrayList<>();
        result.add(new Account(1000, 789));
        result.add(new Account(1000, 555));
        assertThat(bm.getEntry().get(new User("123", "name1")), is(result));
    }
    /**
     * transferMoney if values first user < amount.
     */
    @Test
    public void whenTransferMoneyIfValuesFirstUserInsufficientAmountThenDoNotTransferMoney() {
        BankMap bm = new BankMap();
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 789));
        bm.addAccountToUser(new User("456", "name2"), new Account(1000, 555));
        boolean expected = bm.transferMoney(new User("123", "name1"), new Account(1000, 789), new User("456", "name2"), new Account(1000, 555), 2000D);
        int expected2 = (int) (bm.getEntry().get(new User("123", "name1")).get(0).getValue());
        assertThat((!expected && expected2 == 1000), is(true));
    }
    /**
     * transferMoney if values first user >= amount.
     */
    @Test
    public void whenTransferMoneyIfValuesFirstUserSufficientAmountThenDoNotTransferMoney() {
        BankMap bm = new BankMap();
        bm.addAccountToUser(new User("123", "name1"), new Account(1000, 789));
        bm.addAccountToUser(new User("456", "name2"), new Account(1000, 555));
        boolean expected = bm.transferMoney(new User("123", "name1"), new Account(1000, 789), new User("456", "name2"), new Account(1000, 555), 500D);
        int expected2 = (int) (bm.getEntry().get(new User("123", "name1")).get(0).getValue());
        assertThat((expected && expected2 == 500), is(true));
    }
}
