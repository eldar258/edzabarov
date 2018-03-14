package ru.job4j.notyfyall.threadpool;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class ru.job4j.monitore.threadpool.
 *
 * @author edzabarov
 * @since 13.03.2018
 */
@ThreadSafe
public class ThreadPool {
    @GuardedBy("this")

    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Future add(Work work) {
        return pool.submit(work);
    }
}
