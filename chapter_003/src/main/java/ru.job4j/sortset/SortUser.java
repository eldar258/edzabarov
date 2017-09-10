package ru.job4j.sortset;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Collections;

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

    /**
     * sort by name length.
     * @param list -
     * @return -
     */
    public List<User> sortNameLength(List<User> list) {
        if (list == null) return null;
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result; //= 0;
                if (o1.getName() != null && o2.getName() != null) result = o1.getName().length() - o2.getName().length();
                else if (o1.getName() == o2.getName()) result = 0;
                else if (o1.getName() != null) result = -1;
                else result = 1;
                return result == 0 ? o1.getAge() - o2.getAge() : result;
            }
        });
        return list;
    }

    /**
     * sort by name and age.
     * @param list -
     * @return -
     */
    public List<User> sortByAllFields(List<User> list) {
        if (list == null) return null;
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result; //= 0;
                if (o1.getName() != null) result = o1.getName().compareTo(o2.getName());
                else result = o2.getName() != null ? -1 : 0;
                return result == 0 ? o1.getAge() - o2.getAge() : result;
            }
        });
        return list;
    }
}