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
     * position.
     */
    private int count = 0;
    /**
     * constructor.
     * @param array -
     */
    public TwoDimensionalArray(int[][] array) {
        this.array = array;
    }
    @Override
    public boolean hasNext() {
        return count < array.length * array[0].length;
    }
    @Override
    public Integer next() {
        int i = count / array.length;
        int j = count % array[0].length;
        int result = array[i][j];
        count++;
        return result;
    }
    @Override
    public void remove() {

    }
}
