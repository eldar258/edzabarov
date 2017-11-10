package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Class ru.job4j.map.
 *
 * @author edzabarov
 * @since 10.11.2017
 */
public class UserTest {
    @Test
    public void whenUserPutInMapThenPrintMap() {
        User first = new User("Lacky", 0, new GregorianCalendar(2000, 1, 1));
        User second = new User("Lacky", 0, new GregorianCalendar(2000, 1, 1));
        Map<User, String> map = new HashMap<>();
        map.put(first, "one");
        map.put(second, "two");
        System.out.println((first.hashCode() == second.hashCode()) + " " + first.equals(second) + " " + map);
    }
}