package ru.job4j.convertcollection;

import java.util.List;

/**
 * Class Convert List.
 *
 * @author edzabarov
 * @since 02.09.2017
 */
public class ConvertList {
    /**
     * which list.
     */
    private List<Integer> list;

    /**
     * Construction.
     * @param list - which list.
     */
    public ConvertList(List<Integer> list) {
        this.list = list;
    }

    /**
     * moves the array to list.
     * @param array -
     * @return list -
     */
    public List<Integer> toList(int[][] array) {
        this.list.clear();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                this.list.add(array[i][j]);
            }
        }
        return this.list;
    }

    /**
     * moves the list to array.
     * @param list -
     * @param rows -
     * @return array[][].
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = null;
        if (list != null && !list.isEmpty()) {
            int rem = list.size() % rows;
            array = new int[list.size() / rows + ((rem > 0) ? 1 : 0)][rows];
            int i = 0, j = 0;
            for (Integer el : list) {
                array[i][j] = el;
                if (j < array[i].length - 1) {
                    j++;
                } else if (i < array.length - 1) {
                    i++;
                    j = 0;
                }
            }
            for (; j < rows; j++) {
                array[i][j] = 0; // null
            }
        } else {
            array = new int[1][rows];
            for (int i = 0; i < rows; i++) {
                array[0][i] = 0;
            }
        }
        return array;
    }
}
