package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version 0.1
* @since 25.04.2017
*/
public class CalculatorTest {
	/**
	* Test add.
	*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	* Test substruct.
	*/
	@Test
	public void whenAddTwoSubstructOneThenOne() {
		Calculator calc = new Calculator();
		calc.substruct(2D, 1D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}
	/**
	* Test div.
	*/
	@Test
	public void whenAddTwoDivOneThenTwo() {
		Calculator calc = new Calculator();
		calc.div(2D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	* Test multiple.
	*/
	@Test
	public void whenAddTwoMultipleTwoThenFour() {
		Calculator calc = new Calculator();
		calc.multiple(2D, 2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}
}