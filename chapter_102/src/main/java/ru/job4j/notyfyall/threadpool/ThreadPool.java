package ru.job4j.notyfyall.threadpool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class ru.job4j.monitore.threadpool.
 *
 * @author edzabarov
 * @since 13.03.2018
 */
@ThreadSafe
public class ThreadPool {
    @GuardedBy("this")
    private final int countCore =  Runtime.getRuntime().availableProcessors();
    private final Queue<Work> queue = new LinkedList<>();

    public void add(Work work) {
        synchronized (this) {
            this.notifyAll();
            while (isPoolFull()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(work);
            work.setQueue(queue);
            new Thread(work).start();
        }
    }

    private boolean isPoolFull() {
        return queue.size() == countCore;
    }
}
