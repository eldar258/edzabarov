package ru.job4j.array;

/**
*Class Turn.
*@author edzabarov
*@since 18.07.2017
*/
public class Turn {
	/**
	* back.
	*@param array - array
	*@return array;
	*/
	public int[] back(int[] array) {
		int length = array.length / 2;
		for (int i = 0; i < length; i++) {
			int swap = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = swap;
		}
		return array;
	}
}