package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.set.
 *
 * @author edzabarov
 * @since 01.11.2017
 */
public class SimpleHashSetTest {
    public SimpleHashSet<String> simpleSet = new SimpleHashSet<>();
    String[] result = new String[10];
    {
        simpleSet.add("test1");
        simpleSet.add("test2");
        simpleSet.add("test3");
        result[0] = "test1";
        result[1] = "test2";
        result[2] = "test3";
    }

    @Test
    public void whenSimpleSetAddSameElementsThenInSimpleSetContainsDifferentElements() {
        simpleSet.add("test1");
        String[] expected = new String[10];
        int i = 0;
        for (String el : simpleSet) {
            expected[i++] = el;
        }
        assertThat(expected, is(result));
    }
}