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
	public void whenAddOneSubstructOneThenZero() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 0D;
		assertThat(result, is(expected));
	}
	/**
	* Test div.
	*/
	@Test
	public void whenAddOneDivOneThenOne() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}
	/**
	* Test multiple.
	*/
	@Test
	public void whenAddTwoMultipleTwoThenFour() {
		Calculator calc = new Calculator();
		calc.add(2D, 2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}
}