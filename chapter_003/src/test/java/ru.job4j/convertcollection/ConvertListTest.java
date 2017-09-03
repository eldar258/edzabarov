package ru.job4j.convertcollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Convert List test.
 *
 * @author edzabarov
 * @since 02.09.2017
 */
public class ConvertListTest {
    /**
     * test toList.
     */
    @Test
    public void whenArrayToListThenConvertedToList() {
        List<Integer> result = new ArrayList<>();
        ConvertList convertList = new ConvertList(new ArrayList<Integer>());
        int[][] array = {{1, 2, 3}, {3, 2, 1}, {123, 321, 213}};
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(3);
        result.add(2);
        result.add(1);
        result.add(123);
        result.add(321);
        result.add(213);
        List<Integer> expected = convertList.toList(array);
        assertThat(result, is(expected));
    }
    /**
     * test toArray.
     */
    @Test
    public void whenListToArrayThenConvertedToArray() {
        List<Integer> list = new ArrayList<Integer>();
        ConvertList convertList = new ConvertList(new ArrayList<Integer>());
        int[][] result = {{1, 2, 3}, {3, 2, 1}, {123, 321, 213}, {222, 333, 0}};
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(123);
        list.add(321);
        list.add(213);
        list.add(222);
        list.add(333);
        int[][] expected = convertList.toArray(list, 3);
        assertThat(result, is(expected));
    }
}
