package ru.job4j.iterators;

import java.util.Iterator;

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
        boolean result = true;
        int ptr;
        do {
            try {
                ptr = array[count];
            } catch (IndexOutOfBoundsException ex) {
                result = false;
                break;
            }
            if (ptr <= 1) {
                count++;
                continue;
            }
            int n = ((int) Math.sqrt(ptr));
            for (int i = 2; i <= n; i++) {
                if (ptr % i == 0) {
                    result = false;
                    count++;
                    break;
                }
            }

        } while (!result);
        return result;
    }
    @Override
    public Integer next() {
        int result;
        boolean ptr;
        do {
            result = array[count++];
            if (result <= 1) {
                ptr = true;
                continue;
            }
            ptr = false;
            int n = ((int) Math.sqrt(result));
            for (int i = 2; i <= n; i++) {
                if (result % i == 0) {
                    ptr = true;
                    break;
                }
            }
        } while (ptr);
        return result;
    }

    @Override
    public void remove() {

    }
}
