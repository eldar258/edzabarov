package ru.job4j.iterators;

import java.util.Iterator;

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
        boolean result;
        try {
            do {
                result = array[count] % 2 != 0;
                if (result) count++;
            } while (result);
            result = true;
        } catch (IndexOutOfBoundsException ex) {
            result = false;
        }
        return result;
    }
    @Override
    public Integer next() {
        int result;
        do {
            result = array[count++];
        } while (result % 2 != 0);
        return result;
    }

    @Override
    public void remove() {

    }
}
