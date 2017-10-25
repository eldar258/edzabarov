package ru.job4j.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for SimpleStackTest.
 *
 * @author edzabarov
 * @since 25.10.2017
 */
public class SimpleStackTest {
    private SimpleStack<String> stack = new SimpleStack<>();
    /**
     * test push and poll.
     */
    @Test
    public void whenPushElementInStackThenElementPollAndRemove() {
        stack.push("test3");
        stack.push("test2");
        stack.push("test1");
        String[] result = {"test1", "test2", "test3"};
        String[] expected = {stack.poll(),
                stack.poll(),
                stack.poll()};
        assertThat(expected, is(result));
    }

    /**
     * ExpectedException.
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();
    /**
     * test poll throw Exception.
     */
    @Test
    public void whenPollAndElementNoSuchThrowException() {
        stack.push("test");
        stack.poll();
        exception.expect(NoSuchElementException.class);
        stack.poll();
    }
}