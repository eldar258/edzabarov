package ru.job4j.iterators;

import java.util.ArrayList;
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
    private ArrayList<Integer> evenNumbers;
    /**
     * index current num.
     */
    private int count = 0;

    /**
     * Constructor.
     * @param numbers -
     */
    public EvenNumbersIterator(final int[] numbers) {
        this.evenNumbers = new ArrayList<>();
        for (int el : numbers) {
            if (el % 2 == 0) {
                this.evenNumbers.add(el);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return this.count < this.evenNumbers.size();
    }
    @Override
    public Integer next() {
        return this.evenNumbers.get(this.count++);
    }

    @Override
    public void remove() {

    }
}
