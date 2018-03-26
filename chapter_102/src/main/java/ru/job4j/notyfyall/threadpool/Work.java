package ru.job4j.notyfyall.threadpool;

import java.util.HashSet;
import java.util.Queue;

/**
 * Class ru.job4j.monitore.threadpool.
 *
 * @author edzabarov
 * @since 13.03.2018
 */
public abstract class Work implements Runnable {
    private Queue pool;

    @Override
    public void run() {
        working();
        deleteWork();
    }

    abstract void working();

    public void setQueue(Queue<Work> pool) {
        this.pool = pool;
    }

    private void deleteWork() {
        if (pool != null) {
            pool.remove(this);
        }
    }
}
