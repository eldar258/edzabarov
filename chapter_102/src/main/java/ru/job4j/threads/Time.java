package ru.job4j.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Class ru.job4j.threads.
 *
 * @author edzabarov
 * @since 21.02.2018
 */
public class Time implements Runnable {

    private long startTime;
    private long maxTime;

    private List<Thread> threadsToCompletion = new ArrayList<>();

    public Time(long startTime, long maxTime) {
        this.startTime = startTime;
        this.maxTime = maxTime;
    }

    public void addThread(Thread thread) {
        this.threadsToCompletion.add(thread);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (System.currentTimeMillis() - startTime > maxTime) {
                threadsToCompletion.forEach(Thread::interrupt);
                Thread.currentThread().interrupt();
            }
        }
    }
}
