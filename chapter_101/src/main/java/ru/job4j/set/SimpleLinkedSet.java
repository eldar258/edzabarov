package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ru.job4j.set.
 *
 * @author edzabarov
 * @since 01.11.2017
 */
public class SimpleLinkedSet<E> implements Iterable<E> {
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

    private Entry<E> header = new Entry<E>(null, null, null);
    private Entry<E> lastEntry = header;
    private  int size = 0;

    public SimpleLinkedSet() {
        header.next = lastEntry;
    }

    public boolean add(E e) {
        if (e == null || isContains(e)) return false;
        lastEntry = new Entry<E>(e, null, lastEntry);
        lastEntry.prev.next = lastEntry;
        size++;
        return true;
    }
    private boolean isContains(E e) {
        Entry<E> node = header.next;
        for (int i = 0; i < size; node = node.next, i++) {
            if (e.equals(node.element)) return true;
        }
        return false;
    }

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
