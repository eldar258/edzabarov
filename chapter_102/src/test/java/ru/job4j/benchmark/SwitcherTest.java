package ru.job4j.benchmark;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 20.06.2018
 */
public class SwitcherTest {

    @Test
    public void whenThreadStartThenThreadOneAndThreadToSwitcher() {
        Switcher switcher = new Switcher();
        int count = 1000;
        String expected = switcher.result(count);
        StringBuffer result = new StringBuffer();
        boolean sw = false;
        for (int i = 0; i < count * 20; i++) {
            if (i % 10 == 0) {
                sw = !sw;
            }
            if (sw) {
                result.append(0);
            } else {
                result.append(1);
            }
        }
        //System.out.println(expected.replaceAll("(.{10})", "$1\n"));
        assertThat(expected, is(result.toString()));
    }
}