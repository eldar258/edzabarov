package ru.job4j.notyfyall.simplepool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class ru.job4j.notyfyall.simplepool.
 *
 * @author edzabarov
 * @since 31.05.2018
 */
public class SimpleThreadPool {
    private final Work[] threads;
    private final Queue<Runnable> taskQueue;

    public SimpleThreadPool(int threadNumber) {
        taskQueue = new LinkedList<>();
        threads = new Work[threadNumber];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Work();
            threads[i].start();
        }
    }

    public void add(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    public void close() throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
        }
        //taskQueue.notifyAll();
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }

    private class Work extends Thread {
        @Override
        public void run() {
            Runnable task;
            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    task = taskQueue.poll();
                }
                task.run();
            }
        }
    }
}
