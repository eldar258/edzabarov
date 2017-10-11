package ru.job4j.iterators;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

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
     * ExpectedException.
     */
    @Rule
    public final ExpectedException expected = ExpectedException.none();
    /**
     * test hasNext().
     */
    @Test
    public void whenTheElementsWereFinishedThenHasNextReturnsFalse() {
        TwoDimensionalArray it = new TwoDimensionalArray(new int[][]{{1}, {4, 5}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
        expected.expect(NoSuchElementException.class);
        it.next();
    }
}
