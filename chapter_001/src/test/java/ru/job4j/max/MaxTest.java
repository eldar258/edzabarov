package ru.job4j.max;

/**
* Test.
*
*@author edzabarov
*@version $Id$
*@since 29.04.2017
*/
public class MaxTest {
	/**
	* Test max.
	*/
	@Test
	public void whenAddOneEqulseTwoThenTwo() {
		Max max = new max();
		int result = max.max(1, 2);
		int expected = 2;
		assertThat(result, is(expected));
	}
	/**
	* Test max.
	*/
	@Test
	public void whenAddTwoEqulseOneThenTwo() {
		Max max = new max();
		int result = max.max(2, 1);
		int expected = 2;
		assertThat(result, is(expected));
	}
}