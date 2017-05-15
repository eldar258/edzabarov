package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 15.05.2017
*/
public class FactorialTest {
	/**
	*Test calc.
	*/
	@Test
	public void factFour() {
		int result = new Factorial().calc(4);
		int expected = 24;
		assertThat(result, is(expected));
	}
	/**
	*Test calc.
	*/
	@Test
	public void factFive() {
		int result = new Factorial().calc(5);
		int expected = 120;
		assertThat(result, is(expected));
	}
}