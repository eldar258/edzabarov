package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Iterator for primes number.
 *
 * @author edzabarov
 * @since 27.09.2017
 */
public class PrimesNumberIterator implements Iterator {
    /**
     * prime numbers.
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
    public PrimesNumberIterator(final int[] numbers) {
        this.array = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (!result && count < array.length) {
            if (isPrimeNumber(array[count])) {
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
     * check is prime number.
     * @param value checker number.
     * @return -
     */
    private boolean isPrimeNumber(int value) {
        boolean result = true;
        if (value > 1) {
            int n = ((int) Math.sqrt(value));
            for (int i = 2; i <= n; i++) {
                if (value % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
