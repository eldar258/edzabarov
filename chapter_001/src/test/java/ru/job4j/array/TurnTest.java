package ru.job4j.array;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 18.07.2017
*/
public class TurnTest {
	/**
	*Test back.
	*/
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
		int[] result = {0, 1, 2, 3, 4, 5};
		Turn turn = new Turn();
		result = turn.back(result);
		int[] expected = {5, 4, 3, 2, 1, 0};
		assertThat(result, is(expected));
    }
	/**
	*Test back.
	*/
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        int[] result = {0, 1, 2, 3, 4};
		Turn turn = new Turn();
		result = turn.back(result);
		int[] expected = {4, 3, 2, 1, 0};
		assertThat(result, is(expected));
    }
}