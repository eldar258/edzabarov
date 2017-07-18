package ru.job4j.array;

/**
*Class Turn.
*@author edzabarov
*@since 18.07.2017
*/
public class BubbleSort {
	/**
	* sort.
	*@param array - array
	*@return array;
	*/
	public int[] sort(int[] array) {
		boolean pr = true;
		while (pr) {
			pr = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1] > array[i]) {
					int swap = array[i - 1];
					array[i - 1] = array[i];
					array[i] = swap;
					pr = true;
				}
			}
		}
		return array;
	}
}