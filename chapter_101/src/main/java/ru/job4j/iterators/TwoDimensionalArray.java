package ru.job4j.iterators;

import java.util.Iterator;

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
        boolean result;
        try {
            int ptr = array[counti][countj];
            result = true;
        } catch (IndexOutOfBoundsException ex) {
            result = false;
        }
        return result;
    }

    @Override
    public Integer next() {
        int result;
        try {
            result = array[counti][countj++];
        } catch (IndexOutOfBoundsException ex) {
            counti++;
            countj = 0;
            result = array[counti][countj++];
        }
        return result;
    }
    @Override
    public void remove() {

    }
}
