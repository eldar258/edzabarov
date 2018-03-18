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
    private boolean isLock = false;
    private final Object lock = new Object();

    public void lock() {
        synchronized (this) {
            this.notify();
            if (isLock) {
                try {
                    while (isLock) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            isLock = true;
        }
    }

    public void unlock() {
        synchronized (this) {
            if (isLock) {
                isLock = false;
                this.notify();
            }
        }
    }
}
