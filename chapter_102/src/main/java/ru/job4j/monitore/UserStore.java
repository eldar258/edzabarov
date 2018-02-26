package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * Class ru.job4j.monitore.
 *
 * @author edzabarov
 * @since 26.02.2018
 */
@ThreadSafe
public class UserStore {
    @GuardedBy("this")
    private Map<Integer, User> users = new HashMap<>();

    public boolean add(User user) {
        boolean result = !users.containsKey(user.getId());
        if (result) {
            users.put(user.getId(), user);
        }
        return result;
    }

    public void transfer(int id1, int id2, int value) {
        if (id1 == id2 || value <= 0) return;
        User user1 = users.get(id1);
        User user2 = users.get(id2);
        if (user1 != null && user2 != null && user1.getAmount() >= value) {
            user1.addAmount(-value);
            user2.addAmount(value);
        }
    }

    public boolean update(User user) {
        return users.put(user.getId(), user) != null;
    }

    public boolean delete(User user) {
        return users.remove(user.getId()) != null;
    }
}
