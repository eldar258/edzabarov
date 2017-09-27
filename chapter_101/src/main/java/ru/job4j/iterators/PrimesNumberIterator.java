package ru.job4j.iterators;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Iterator for primes number.
 *
 * @author edzabarov
 * @since 27.09.2017
 */
public class PrimesNumberIterator implements Iterator {
    /**
     * ArrayList prime numbers.
     */
    private ArrayList<Integer> primesNumbers;
    /**
     * index current num.
     */
    private int count = 0;

    /**
     * Constructor.
     * @param numbers -
     */
    public PrimesNumberIterator(final int[] numbers) {
        this.primesNumbers = new ArrayList<>();
        for (int el : numbers) {
            if (el <= 1) {
                continue;
            }
            int n = ((int) Math.sqrt(el));
            boolean ptr = true;
            for (int i = 2; i <= n; i++) {
                if (el % i == 0) {
                    ptr = false;
                    break;
                }
            }
            if (ptr) {
                this.primesNumbers.add(el);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return this.count < this.primesNumbers.size();
    }
    @Override
    public Integer next() {
        return this.primesNumbers.get(this.count++);
    }

    @Override
    public void remove() {

    }
}
