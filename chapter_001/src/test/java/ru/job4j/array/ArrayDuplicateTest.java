package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 20.07.2017
*/
public class ArrayDuplicateTest {
	/**
	*Test remove.
	*/
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		String[] primary = {"Привет", "Мир", "Привет", "Супер", "Мир"};
		ArrayDuplicate ad = new ArrayDuplicate();
		String[] result = ad.remove(primary);
		String[] expected = {"Привет", "Мир", "Супер"};
		assertThat(result, is(expected));
    }
	/**
	*Test remove.
	*/
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
		String[] primary = {"1", "4", "3", "4", "4", "3", "2", "2", "2", "3", "4"};
		ArrayDuplicate ad = new ArrayDuplicate();
		String[] result = ad.remove(primary);
		String[] expected = {"1", "4", "3", "2"};
		assertThat(result, is(expected));
    }
}