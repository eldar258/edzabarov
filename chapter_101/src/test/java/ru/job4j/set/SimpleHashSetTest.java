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
    public SimpleHashSet<String> simpleSet;
    public String[] result = new String[10];

    public void createRawData(int scope) {
        simpleSet = new SimpleHashSet<>(scope);
        result = new String[10];
        simpleSet.add("test1");
        simpleSet.add("test2");
        simpleSet.add("test3");
        result[0] = "test1";
        result[1] = "test2";
        result[2] = "test3";
    }

    public void convertArray(String[] expected) {
        int i = 0;
        for (String el : simpleSet) {
            expected[i++] = el;
        }
    }

    @Test
    public void whenSimpleSetAddSameElementsThenInSimpleSetContainsDifferentElements() {
        createRawData(1000);
        boolean boolFalse = simpleSet.add("test1");
        String[] expected = new String[10];
        convertArray(expected);
        assertThat(expected, is(result));
        assertThat(boolFalse, is(false));
    }
    @Test
    public void whenSimpleSetScopeHashExactlyThreeThenSetContainsDifferentElements() {
        createRawData(3);
        boolean boolFalse = simpleSet.add("test4");
        String[] expected = new String[10];
        convertArray(expected);
        assertThat(expected, is(result));
        assertThat(boolFalse, is(false));
    }
}