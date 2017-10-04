package ru.job4j.iterators;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class test.
 *
 * @author edzabarov
 * @since 22.09.2017
 */
public class TwoDimensionalArrayTest {
    /**
     * test next().
     */
    @Test
    public void whenNextThenReturnsTheCurrentElement() {
        TwoDimensionalArray tda = new TwoDimensionalArray(new int[][]{{1, 2}, {3, 4}});
        tda.next();
        tda.next();
        tda.next();
        int expected = tda.next();
        assertThat(expected, is(4));
    }
    /**
     * test next().
     */
    @Test
    public void whenNextThenReturnsTheCurrentElement2() {
        TwoDimensionalArray tda = new TwoDimensionalArray(new int[][]{{1}, {2, 3}});
        tda.next();
        tda.next();
        int expected = tda.next();
        assertThat(expected, is(3));
    }

    /**
     * test hasNext().
     */
    @Test
    public void whenTheElementsWereFinishedThenHasNextReturnsFalse() {
        TwoDimensionalArray tda = new TwoDimensionalArray(new int[][]{{1, 2}, {3, 4}});
        tda.next();
        tda.next();
        tda.next();
        boolean result = tda.hasNext();
        tda.next();
        boolean expected = tda.hasNext();
        assertThat(expected, is(!result));
    }
}
