package ru.job4j.notyfyall.simplepool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class ru.job4j.notyfyall.simplepool.
 *
 * @author edzabarov
 * @since 31.05.2018
 */
public class SimpleThreadPoolTest {
    private final int n = 10000;

    private class TestClass {
        public int a = 0;
        public void incr() {
            a++;
        }
    }
    private class TestThread extends Thread {
        public final TestClass testClass;

        public TestThread(TestClass testClass) {
            this.testClass = testClass;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                synchronized (testClass) {
                    testClass.incr();
                }
            }
        }
    }

    @Test
    public void whenThreadPollAdd100ThreadsThenExecutedSequentially() {
        TestClass testClass = new TestClass();
        SimpleThreadPool threadPool = new SimpleThreadPool(4);
        for (int i = 0; i < n; i++) {
            threadPool.add(new TestThread(testClass));
        }
        try {
            threadPool.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(testClass.a);
    }
}