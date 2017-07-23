package ru.job4j.benchmark;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 23.07.2017
*/
public class CombSortArraysTest {
	/**
	*Test comb.
	*/
    @Test
    public void whenTwoSortedArraysCombinedThenSortedArray() {
		int[] firstAr = {1, 3, 4, 7};
		int[] secondAr = {2, 5, 6};
		CombSortArrays csa = new CombSortArrays();
		int[] result = csa.comb(firstAr, secondAr);
		int[] expected = {1, 2, 3, 4, 5, 6, 7};
		assertThat(result, is(expected));
    }
	/**
	*Test comb.
	*/
    @Test
    public void whenTwoSortedArraysCombinedThenSortedArray2() {
		int[] firstAr = {1, 2, 100, 200, 300};
		int[] secondAr = {1, 2, 5, 25, 30, 301, 302, 303, 322};
		CombSortArrays csa = new CombSortArrays();
		int[] result = csa.comb(firstAr, secondAr);
		int[] expected = {1, 1, 2, 2, 5, 25, 30, 100, 200, 300, 301, 302, 303, 322};
		assertThat(result, is(expected));
    }
	/**
	*Test comb.
	*/
    @Test
    public void whenTwoSortedArraysCombinedThenSortedArray3() {
		int[] firstAr = {1, 2, 3, 4};
		int[] secondAr = {1, 2, 3, 5};
		CombSortArrays csa = new CombSortArrays();
		int[] result = csa.comb(firstAr, secondAr);
		int[] expected = {1, 1, 2, 2, 3, 3, 4, 5};
		assertThat(result, is(expected));
    }
}