package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ru.job4j.set.
 *
 * @author edzabarov
 * @since 31.10.2017
 */
public class SimpleSet<E> implements Iterable<E> {

    private Object[] container;
    int size = 0;

    public SimpleSet() {
        container = new Object[10];
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count != size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return container(count++);
            }
        };
    }
    public void add(E value) {
        ensureCapacity();
        if (value == null) return;
        for (int i = 0; i < size; i++) {
            if (value.equals(container(i))) return;
        }
        container[size++] = value;
    }
    @SuppressWarnings("unchecked")
    private E container(int index) {
        return (E) container[index];
    }
    private void ensureCapacity() {
        if (size == container.length) {
            container = Arrays.copyOf(container, size * 3 / 2 + 1);
        }
    }
}
