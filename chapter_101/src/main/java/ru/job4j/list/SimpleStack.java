package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Class stack.
 *
 * @author edzabarov
 * @since 25.10.2017
 * @param <E> - Generic.
 */
public class SimpleStack<E> {
    private Entry<E> header = new Entry<E>(null, null);
    private int size = 0;

    public void push(E e) {
        header = new Entry<E>(e, header);
        size++;
    }
    public E poll() {
        if (size == 0) throw new NoSuchElementException();
        size--;
        E result = header.element;
        header = header.prev;
        return result;
    }
    private static class Entry<E> {
        private E element;
        private Entry<E> prev;

        private Entry(E element, Entry<E> prev) {
            this.element = element;
            this.prev = prev;
        }
    }
}
