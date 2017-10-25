package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ru.job4j.list.
 *
 * @author edzabarov
 * @since 24.10.2017
 * @param <E> - Generic.
 */
public class SimpleLinkedList<E> implements Iterable<E> {
    /**
     * head of list.
     */
    private Entry<E> header = new Entry<E>(null, null, null);
    private Entry<E> lastEntry = header;

    public SimpleLinkedList() {
        header.next = lastEntry;
    }

    /**
     * number of elements in list.
     */
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Entry<E> head = header.next;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E result = head.element;
                head = head.next;
                return result;
            }
        };
    }

    /**
     * add element.
     * @param e -
     */
    public void add(E e) {
        lastEntry = new Entry<E>(e, null, lastEntry);
        lastEntry.prev.next = lastEntry;
        size++;
    }

    /**
     * get element.
     * @param index -
     * @return -
     */
    public E get(int index) {
        return entry(index).element;
    }

    /**
     * get link.
     * @param index -
     * @return -
     */
    private Entry<E> entry(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Entry<E> e = header;
        for (int i = 0; i <= index; i++) {
            e = e.next;
        }
        return e;
    }

    /**
     * class chain.
     * @param <E>
     */
    private static class Entry<E> {
        /**
         * element.
         */
        private E element;
        /**
         * next link.
         */
        private Entry<E> next;
        /**
         * prevision link.
         */
        private Entry<E> prev;

        /**
         * constructor.
         * @param element -
         * @param next -
         * @param prev -
         */
        private Entry(E element, Entry<E> next, Entry<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
