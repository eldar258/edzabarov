package ru.job4j.benchmark;

/**
*Class CombSortArrays.
*@author edzabarov
*@since 23.07.2017
*/
public class CombSortArrays {
	/**
	* comb.
	*@param firstAr - array int
	*@param secondAr - array int
	*@return array;
	*/
	public int[] comb(int[] firstAr, int[] secondAr) {
		int[] array = new int[firstAr.length + secondAr.length];
		int i = 0, j = 0, z = 0;
		for (; i < firstAr.length && j < secondAr.length; z++) {
			array[z] = firstAr[i] < secondAr[j] ? firstAr[i++] : secondAr[j++];
		}
		for (; i < firstAr.length; z++, i++) {
			array[z] = firstAr[i];
		}
		for (; j < secondAr.length; z++, j++) {
			array[z] = secondAr[j];
		}
		return array;
	}
}