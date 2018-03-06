package ru.job4j.notyfyall;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class ru.job4j.notyfyall.
 *
 * @author edzabarov
 * @since 06.03.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    private int maxSize = 10;
    private final Object lock = new Object();

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) throws InterruptedException {
        synchronized (lock) {
            lock.notify();
            while (isFull()) {
                lock.wait();
            }
            queue.add(value);
        }
    }

    public T peek() throws InterruptedException {
        synchronized (lock) {
            lock.notify();
            while (isEmpty()) {
                lock.wait();
            }
            return queue.poll();
        }
    }
    public synchronized boolean isFull() {
        return queue.size() >= maxSize;
    }
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
    public synchronized int size() {
        return queue.size();
    }
}