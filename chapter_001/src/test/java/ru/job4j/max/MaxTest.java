package ru.job4j.max;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
		Max max = new Max();
		int result = max.max(1, 2);
		int expected = 2;
		assertThat(result, is(expected));
	}
	/**
	* Test max.
	*/
	@Test
	public void whenAddTwoEqulseOneThenTwo() {
		Max max = new Max();
		int result = max.max(2, 1);
		int expected = 2;
		assertThat(result, is(expected));
	}
}