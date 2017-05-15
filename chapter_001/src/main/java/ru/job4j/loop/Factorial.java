package ru.job4j.loop;

/**
*Class Factorial.
*@author edzabarov
*@since 7.05.2017
*/
class Factorial {
	/**
	* calc.
	*@param n - n
	*@return fact;
	*/
	public int calc(int n) {
		//n == 0 ? return 1 : return n*calc(n-1);
		int fact = 1;
		for (int i = n; i > 0; i--) {
			fact *= i;
		}
		return fact;
	}
}