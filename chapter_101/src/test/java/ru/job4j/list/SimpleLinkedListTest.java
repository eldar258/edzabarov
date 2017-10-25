package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.list.
 *
 * @author edzabarov
 * @since 25.10.2017
 */
public class SimpleLinkedListTest {
    public SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
    @Test
    public void whenIteratorThenIterator() {
        linkedList.add("test1");
        linkedList.add("test2");
        linkedList.add("test3");
        Iterator<String> iterator = linkedList.iterator();
        String[] expected = {iterator.next(), iterator.next(), iterator.next()};
        String[] result = {"test1", "test2", "test3"};
    }

    @Test
    public void whenAddThenGetElement() {
        linkedList.add("test1");
        linkedList.add("test2");
        linkedList.add("test3");
        String expected = linkedList.get(1);
        String result = "test2";
        assertThat(expected, is(result));
    }

}