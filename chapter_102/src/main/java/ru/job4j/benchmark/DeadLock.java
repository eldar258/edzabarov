package ru.job4j.benchmark;


import java.util.concurrent.CountDownLatch;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 20.06.2018
 */
public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private CountDownLatch cdl = new CountDownLatch(2);

    public static void main(String[] args) {
        new DeadLock().go();
    }

    private void go() {
        Thread deadThread1 = new Thread(new DeadThread1());
        Thread deadThread2 = new Thread(new DeadThread2());

        deadThread1.start();
        deadThread2.start();
    }

    public class DeadThread1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                cdl.countDown();
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Yes!");
                synchronized (lock2) {
                    System.out.println("NOT DEAD LOCK");
                }
            }
        }
    }

    public class DeadThread2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock2) {
                cdl.countDown();
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadLock!");
                synchronized (lock1) {
                    System.out.println("NOT DEAD LOCK");
                }
            }
        }
    }
}
