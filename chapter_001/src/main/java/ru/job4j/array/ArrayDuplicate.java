package ru.job4j.array;

import java.util.Arrays;
/**
*Class ArrayDuplicate.
*@author edzabarov
*@since 20.07.2017
*/
public class ArrayDuplicate {
	/**
	* remove.
	*@param array - array
	*@return array;
	*/
	public String[] remove(String[] array) {
		int clean = 0;
		for (int i = 0; i < (array.length - clean - 1); i++) {
			for (int j = 1 + i; j < (array.length - clean); j++) {
				if (array[i].equals(array[j])) {
					if (array[j].equals(array[array.length - clean - 1])) { //в том случае, если последний эл. соответствует текущему при перестановке
						clean++;
						j--;
						continue;
					}
					String tmp = array[j];
					array[j] = array[array.length - clean - 1];
					array[array.length - clean - 1] = tmp;
					clean++;
				}
			}
		}
		return (String[]) Arrays.copyOf(array, array.length - clean);
	}
}