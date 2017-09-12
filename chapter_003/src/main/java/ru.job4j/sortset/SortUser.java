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
                int result;
                try {
                    result = o1.getName().length() - o2.getName().length(); // сработает, только если name != null у обоих объектов
                } catch (NullPointerException ex) { //какой - то из name == null
                    result = o1.getName() == null ? -1 : 1; // проверка первого на null. Если так, то он меньше.
                    if (o1.getName() == o2.getName()) result = 0; // проверка на равенство первого и второго. Если равны, значит оба равны null.
                }
                return result;
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
                int result;
                try {
                    result = o1.getName().compareTo(o2.getName());
                } catch (NullPointerException ex) {
                    result = o1.getName() == null ? -1 : 1;
                    if (o1.getName() == o2.getName()) result = 0;
                }
                return result == 0 ? o1.getAge() - o2.getAge() : result;
            }
        });
        return list;
    }
}