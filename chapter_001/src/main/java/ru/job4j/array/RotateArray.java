package ru.job4j.array;

/**
*Class RatateArray.
*@author edzabarov
*@since 19.07.2017
*/
public class RotateArray {
	/**
	* rotate.
	*@param array - array
	*@return array;
	*/
	public int[][] rotate(int[][] array) {
		int[] auxiliary = new int[array.length * array.length];
		for (int i = 0, z = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++, z++) {
				auxiliary[z] = array[i][j];
			}
		}
		for (int i = 0, z = 0; i < array.length; z = ++i) {
			for (int j = 0; j < array.length; j++) {
				z = (z + array.length * (array.length - 1)) % auxiliary.length;
				array[i][j] = auxiliary[z];
			}
		}
		return array;
	}
}