package ru.job4j.condition;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 29.04.2017
*/
public class TriangleTest {
	/**
	*Test area.
	*/
	@Test
	public void whenThreePointAreaThen9() {
		Point a = new Point(1, 1);
		Point b = new Point(-2, 4);
		Point c = new Point(-2, -2);
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.area();
		double expected = 9D;
		assertThat(result, closeTo(expected, 0.01));
	}
	/**
	*Test area.
	*/
	@Test
	public void whenThreePointAreaThen0p5() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 3);
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.area();
		double expected = 0.5D;
		assertThat(result, closeTo(expected, 0.01));
	}
	/**
	*Test area.
	*/
	@Test
	public void whenThreePointAreaThen16() {
		Point a = new Point(1, 2);
		Point b = new Point(-2, 3);
		Point c = new Point(6, 11);
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.area();
		double expected = 16D;
		assertThat(result, closeTo(expected, 0.01));
	}
	/**
	*Test area.
	*/
	@Test
	public void whenThreePointAreaThen0() {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 2);
		Triangle triangle = new Triangle(a, b, c);
		double result = triangle.area();
		double expected = 0D;
		assertThat(result, closeTo(expected, 0.01));
	}
}