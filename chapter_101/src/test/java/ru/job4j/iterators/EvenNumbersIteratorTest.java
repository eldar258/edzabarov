package ru.job4j.iterators;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for even numbers.
 *
 * @author edzabarov
 * @since 25.09.2017
 */
public class EvenNumbersIteratorTest {
    /**
     * next().
     */
    @Test
    public void whenNextThenGetEvenNumbers() {
        EvenNumbersIterator eNum = new EvenNumbersIterator(new int[]{1, 2, 3, 4, 5, 6});
        int[] expected = {eNum.next(), eNum.next(), eNum.next()};
        assertThat(expected, is(new int[]{2, 4, 6}));
    }
    /**
     * test hasNext().
     */
    @Test
    public void whenTheElementsWereFinishedThenHasNextReturnsFalse() {
        EvenNumbersIterator eNum = new EvenNumbersIterator(new int[]{2, 2, 2});
        eNum.next();
        eNum.next();
        boolean result = eNum.hasNext();
        eNum.next();
        boolean expected = eNum.hasNext();
        assertThat(expected, is(!result));
    }
}
