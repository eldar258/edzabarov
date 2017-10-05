package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class SimpleArrayTest.
 *
 * @author edzabarov
 * @since 05.10.2017
 */
public class SimpleArrayTest {
    /**
     * test.
     */
    @Test
    public void whenValuesTakesSimpleListThenThenReturnIt() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        String[] expected = {simpleArray.get(0), simpleArray.get(1), simpleArray.get(2)};
        String[] result = {"test1", "test2", "test3"};
        assertThat(expected, is(result));
    }
}
