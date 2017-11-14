package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.map.
 *
 * @author edzabarov
 * @since 14.11.2017
 */
public class DirectoryMapTest {
    @Test
    public void whenMapTakeValueThenMapGetValue() {
        DirectoryMap<String, String> map = new DirectoryMap<>();
        map.put("one", "test1");
        map.put("two", "test2");
        map.put("three", "test3");
        String[] expected = {map.get("one"), map.get("two"), map.get("three")};
        String[] result = {"test1", "test2", "test3"};
        assertThat(expected, is(result));
        Iterator<String> it = map.iterator();
        String[] expected2 = {it.next(), it.next(), it.next()};
        assertThat(expected2, is(result));
    }
}