package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 19.07.2017
*/
public class RotateArrayTest {
	/**
	*Test rotate.
	*/
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
		int[][] result = {{1, 5}, {7, 8}};
		RotateArray ra = new RotateArray();
		result = ra.rotate(result);
		int[][] expected = {{7, 1}, {8, 5}};
		assertThat(result, is(expected));
    }
	/**
	*Test rotate.
	*/
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        int[][] result = {{1, 5, 4}, {2, 3, 1}, {7, 8, 0}};
		RotateArray ra = new RotateArray();
		result = ra.rotate(result);
		int[][] expected = {{7, 2, 1}, {8, 3, 5}, {0, 1, 4}};
		assertThat(result, is(expected));
    }
	/**
	*Test rotate.
	*/
    @Test
    public void whenRotateFourRowFourColArrayThenRotatedArray() {
		int[][] result = {{00, 01, 02, 03}, {10, 11, 12, 13}, {20, 21, 22, 23}, {30, 31, 32, 33}};
		RotateArray ra = new RotateArray();
		result = ra.rotate(result);
		int[][] expected = {{30, 20, 10, 00}, {31, 21, 11, 01}, {32, 22, 12, 02}, {33, 23, 13, 03}};
		assertThat(result, is(expected));
    }
}