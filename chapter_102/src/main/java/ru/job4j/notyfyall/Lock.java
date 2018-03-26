package ru.job4j.notyfyall;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class ru.job4j.notyfyall.
 *
 * @author edzabarov
 * @since 17.03.2018
 */
@ThreadSafe
public class Lock {
    @GuardedBy("this")
    private Thread owner;

    public void lock() {
        synchronized (this) {
            while (owner != null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            owner = Thread.currentThread();
        }
    }

    public void unlock() {
        synchronized (this) {
            if (owner == Thread.currentThread()) {
                owner = null;
                this.notifyAll();
            }
        }
    }
}
