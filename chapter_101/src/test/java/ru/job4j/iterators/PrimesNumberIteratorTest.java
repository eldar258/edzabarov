package ru.job4j.iterators;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class test PrimesNumberIterator.
 *
 * @author edzabarov
 * @since 27.09.2017
 */
public class PrimesNumberIteratorTest {
    /**
     * next().
     */
    @Test
    public void whenNextThenGetPrimeNumbers() {
        PrimesNumberIterator pNum = new PrimesNumberIterator(new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 100, 12345, 27644437});
        int[] expected  = {pNum.next(), pNum.next(), pNum.next(), pNum.next(), pNum.next(), pNum.next()};
        int[] result = {2, 3, 5, 7, 11, 27644437};
        assertThat(expected, is(result));
    }
    /**
     * next().
     */
    @Test
    public void whenNextThenGetPrimeNumbers2() {
        PrimesNumberIterator pNum = new PrimesNumberIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
        int[] expected  = {pNum.next(), pNum.next(), pNum.next(), pNum.next()};
        int[] result = {2, 3, 5, 7};
        assertThat(expected, is(result));
    }
    /**
     * test hasNext().
     */
    @Test
    public void whenTheElementsWereFinishedThenHasNextReturnsFalse() {
        PrimesNumberIterator pNum = new PrimesNumberIterator(new int[]{2, 2, 2});
        pNum.next();
        pNum.next();
        boolean result = pNum.hasNext();
        pNum.next();
        boolean expected = pNum.hasNext();
        assertThat(expected, is(!result));
    }
}
