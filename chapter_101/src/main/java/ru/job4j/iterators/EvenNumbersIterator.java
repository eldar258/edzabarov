package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for even numbers.
 *
 * @author edzabarov
 * @since 25.09.2017
 */
public class EvenNumbersIterator implements Iterator {
    /**
     * ArrayList even numbers.
     */
    private int[] array;
    /**
     * index current num.
     */
    private int count = 0;

    /**
     * Constructor.
     * @param numbers -
     */
    public EvenNumbersIterator(final int[] numbers) {
        this.array = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (!result && count < array.length) {
            if (isEvenNumber(array[count])) {
                result = true;
            } else {
                count++;
            }
        }
        return result;
    }
    @Override
    public Integer next() {
        int result;
        if (hasNext()) {
            result = array[count++];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    /**
     * check number is even.
     * @param value - number.
     * @return -
     */
    private boolean isEvenNumber(int value) {
        return value % 2 == 0;
    }
}
