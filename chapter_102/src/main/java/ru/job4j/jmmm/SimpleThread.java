package ru.job4j.jmmm;

/**
 * Class ru.job4j.JMM.
 *
 * @author edzabarov
 * @since 23.02.2018
 */
public class SimpleThread implements Runnable {

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SimpleThread.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000000; i++) {
            this.count++;
        }
    }
}
