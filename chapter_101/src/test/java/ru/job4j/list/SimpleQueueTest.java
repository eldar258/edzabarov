package ru.job4j.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test SimpleQueue.
 *
 * @author edzabarov
 * @since 25.10.2017
 */
public class SimpleQueueTest {
    private SimpleQueue<String> queue = new SimpleQueue<>();
    /**
     * test push and pull.
     */
    @Test
    public void whenPushElementInQueueThenElementPollAndRemove() {
        queue.push("test1");
        queue.push("test2");
        queue.push("test3");
        String[] result = {"test1", "test2", "test3"};
        String[] expected = {queue.poll(),
                queue.poll(),
                queue.poll()};
        assertThat(expected, is(result));
    }
    /**
     * ExpectedException.
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void whenPollAndElementNoSuchThrowException() {
        queue.push("test");
        queue.poll();
        exception.expect(NoSuchElementException.class);
        queue.poll();
    }
}