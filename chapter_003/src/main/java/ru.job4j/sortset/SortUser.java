package ru.job4j.sortset;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortUser.
 *
 * @author edzabarov
 * @since 09.09.2017
 */
public class SortUser {
    /**
     * sort list user.
     * @param list -
     * @return ser.
     */
    public Set<User> sort(List<User> list) {
        if (list == null) return null;
        Set<User> set = new TreeSet<>();
        list.forEach(set::add);
        return set;
    }
}