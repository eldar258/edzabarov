package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Class SimpleQueue.
 *
 * @author edzabarov
 * @since 25.10.2017
 */
public class SimpleQueue<E> {
    private Entry<E> header = new Entry<E>(null);
    private Entry<E> lastEntry = header;
    private int size = 0;

    public SimpleQueue() {
        header.next = this.lastEntry;
    }

    public void push(E e) {
        lastEntry.next = new Entry<E>(e);
        lastEntry = lastEntry.next;
        size++;
    }
    public E poll() {
        if (size == 0) throw new NoSuchElementException();
        size--;
        E result = header.next.element;
        header = header.next;
        return result;
    }

    private static class Entry<E> {
        private E element;
        private Entry<E> next;

        private Entry(E element) {
            this.element = element;
        }
    }
}
