package ru.job4j.jmmm;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.jmmm.
 *
 * @author edzabarov
 * @since 23.02.2018
 */
public class SimpleThreadTest {

    Thread simpleThread1 = new Thread(new SimpleThread());
    Thread simpleThread2 = new Thread(new SimpleThread());

    @Test
    public void whenTheThreadsWorkInTurnThenResultIsCorrect() {
        SimpleThread.setCount(0);
        simpleThread1.start();
        try {
            simpleThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        simpleThread2.start();
        try {
            simpleThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count = SimpleThread.getCount();
        System.out.println(count);
        boolean expected = count == 2000000000;
        boolean result = true;
        assertThat(expected, is(result));
    }

    @Test
    public void whenTheThreadsDoNotWorkInTurnThenResultIsNotCorrect() {
        SimpleThread.setCount(0);
        simpleThread1.start();
        simpleThread2.start();
        try {
            simpleThread1.join();
            simpleThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count = SimpleThread.getCount();
        System.out.println(count);
        boolean expected = count == 2000000000;
        boolean result = false;
        assertThat(expected, is(result));
    }
}