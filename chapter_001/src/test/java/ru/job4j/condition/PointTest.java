package ru.job4j.condition;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 11.04.2017
*/
public class PointTest {
	/**
	*Test is.
	*/
	@Test
	public void whenPointZeroZeroAddZeroZeroThenTrue() {
		Point point = new Point(0, 0);
		boolean result = point.is(0, 0);
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	*Test is.
	*/
	@Test
	public void whenPointFourFiveAddTwoNegThreeThenTrue() {
		Point point = new Point(4, 5);
		boolean result = point.is(2, -3);
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	*Test is.
	*/
	@Test
	public void whenPointFourFiveAddTwoThreeThenFalse() {
		Point point = new Point(4, 5);
		boolean result = point.is(2, 3);
		boolean expected = false;
		assertThat(result, is(expected));
	}
}