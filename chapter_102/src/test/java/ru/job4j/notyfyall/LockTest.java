package ru.job4j.notyfyall;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ru.job4j.notyfyall.
 *
 * @author edzabarov
 * @since 17.03.2018
 */
public class LockTest {

    private final int n = 1000000;

    private class SimpleThread implements Runnable {
        private Count count;
        private Lock lock;

        SimpleThread(Count count, Lock lock) {
            this.count = count;
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i < n; i++) {
                count.count++;
            }
            lock.unlock();
        }
    }

    private class Count {
        public int count = 0;
    }

    @Test
    public void whenThreadsLockThenThreadsLocked() {
        Count count = new Count();
        List<Thread> list = new ArrayList<>();
        Lock lock = new Lock();
        int j = 1000;
        for (int i = 0; i < j; i++) {
            Thread thread = new Thread(new SimpleThread(count, lock));
            thread.start();
            list.add(thread);
        }
        for (Thread el : list) {
            try {
                el.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int expected = count.count;
        int result = n * j;
        assertThat(expected, is(result));
    }
}