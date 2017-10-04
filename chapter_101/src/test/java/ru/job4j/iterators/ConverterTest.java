package ru.job4j.iterators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class test Converter.
 *
 * @author edzabarov
 * @since 05.10.2017
 */
public class ConverterTest {
    /**
     * test next().
     */
    @Test
    public void whenItHasMoreThenInnerIt() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>(list1);
        List<Integer> list3 = new ArrayList<>(list2);
        Iterator<Iterator<Integer>> iterator = Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()).iterator();
        Iterator<Integer> it = new Converter().convert(iterator);
        int expected = it.next() + it.next() + it.next() + it.next() + it.next() + it.next() + it.next() + it.next() + it.next(); //9
        int result = (1 + 2 + 3) * 3;
        assertThat(expected, is(result));
    }
    /**
     * test hasNext().
     */
    @Test
    public void whenItElIteratorsFinishedThenHasNextReturnFalse() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        Iterator<Iterator<Integer>> iterator = Arrays.asList(list1.iterator(), list2.iterator()).iterator();
        Iterator<Integer> it = new Converter().convert(iterator);
        it.next();
        it.next();
        boolean result = it.hasNext();
        it.next();
        boolean expected = it.hasNext();
        assertThat(expected, is(!result));
    }
}
