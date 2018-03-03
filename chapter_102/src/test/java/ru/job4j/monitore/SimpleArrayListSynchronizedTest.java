package ru.job4j.monitore;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.monitore.
 *
 * @author edzabarov
 * @since 03.03.2018
 */
public class SimpleArrayListSynchronizedTest {

    private class SimpleThread implements Runnable {
        SimpleArrayListSynchronized<Integer> list;

        public SimpleThread(SimpleArrayListSynchronized<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                list.add(i);
            }
        }
    }

    @Test
    public void whenAdd500000ElementsThenCountElementsEquals500000() {
        SimpleArrayListSynchronized<Integer> list = new SimpleArrayListSynchronized<>();
        ArrayList<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleThread(list));
            thread.start();
            threadList.add(thread);
        }
        try {
            for (Thread el : threadList) {
                el.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int expected = list.size();
        int result = 500000; // 10 * 50000 el
        assertThat(expected, is(result));
    }
}