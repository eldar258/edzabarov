package ru.job4j.calculator;

/**
*Class Calculator.
*@author edzabarov
*@since 25.04.2007
*/
public class Calculator {
	/**
	* result.
	*@param void - void.
	*/
	private double result;
	/**
	* getResult.
	*@return result.
	*/
	public double getResult() {
		return this.result;
	}
	/**
	* add.
	*@param first - first.
	*@param second - second.
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	* substruct.
	*@param first - first.
	*@param second - second.
	*/
	public void substruct(double first, double second) {
		this.result = first - second;
	}
	/**
	* div.
	*@param first - first.
	*@param second - second.
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	* multiple.
	*@param first - first.
	*@param second - second.
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
}