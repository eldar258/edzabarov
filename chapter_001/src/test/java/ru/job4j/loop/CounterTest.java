package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 7.05.2017
*/
public class CounterTest {
	/**
	*Test add.
	*/
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
		int result = counter.add(1, 10);
		int expected = 30;
		assertThat(result, is(expected));
    }
}