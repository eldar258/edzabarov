package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ru.ru.job4j.iterators.
 *
 * @author edzabarov
 * @since 22.09.2017
 */
public class TwoDimensionalArray implements Iterator {
    /**
     * Two-Dimensional Array.
     */
    private int[][] array = null;
    /**
     * row position.
     */
    private int counti = 0;
    /**
     * column position.
     */
    private int countj = 0;
    /**
     * constructor.
     * @param array -
     */
    public TwoDimensionalArray(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = checkIndex();
        if (!result) {
            counti++;
            countj = 0;
            result = checkIndex();
        }
        return result;
    }

    @Override
    public Integer next() {
        int result;
        if (hasNext()) {
            result = array[counti][countj++];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    /**
     * check index out of array.
     * @return -
     */
    private boolean checkIndex() {
        return counti < array.length && countj < array[counti].length;
    }
}
