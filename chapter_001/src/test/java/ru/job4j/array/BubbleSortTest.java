package ru.job4j.array;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 18.07.2017
*/
public class BubbleSortTest {
	/**
	*Test sort.
	*/
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
		int[] result = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
		BubbleSort bs = new BubbleSort();
		result = bs.sort(result);
		int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
		assertThat(result, is(expected));
    }
}