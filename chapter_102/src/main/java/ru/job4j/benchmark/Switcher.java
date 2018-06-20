package ru.job4j.benchmark;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 20.06.2018
 */
public class Switcher {
    MyString myString = new MyString();

    private CyclicBarrier barrier = new CyclicBarrier(2);

    public String result(int count) {
        myString = new MyString();

        Thread one = new Thread(new Adder(count, 0, false));
        Thread two = new Thread(new Adder(count, 1, true));

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println(myString.toString().replaceAll("(.{10})", "$1\n"));
        return myString.toString();
    }

    private class Adder implements Runnable {
        private int val;
        private boolean flag;
        private int count;

        public Adder(int count, int val, boolean flag) {
            this.count = count;
            this.val = val;
            this.flag = flag;
        }

        @Override
        public void run() {
            for (int n = 0; n < count; n++) {
                if (flag) {
                    try {
                        flag = false;
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        return;
                    }
                }
                for (int i = 0; i < 10; i++) {
                    myString.putValue(val);
                }
                flag = true;
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    return;
                }
            }
            barrier.reset();
        }
    }
}
