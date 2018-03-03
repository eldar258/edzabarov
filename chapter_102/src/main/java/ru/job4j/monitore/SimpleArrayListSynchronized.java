package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArrayList.
 *
 * @author edzabarov
 * @since 19.10.2017
 * @param <E> - Generic.
 */
@ThreadSafe
public class SimpleArrayListSynchronized<E> implements Iterable<E> {
    @GuardedBy("this")
    /**
     * element data.
     */
    private Object[] container;
    /**
     * size of array.
     */
    private int size = 0;

    /**
     * Constructor.
     */
    public SimpleArrayListSynchronized() {
        this(10);
    }
    /**
     * Constructor.
     * @param initialSize -
     */
    public SimpleArrayListSynchronized(int initialSize) {
        container = new Object[initialSize];
    }

    /**
     * add element.
     * @param value -
     * @return -
     */
    public synchronized boolean add(E value) {
        ensureCapacity();
        container[size++] = value;
        return true;
    }

    /**
     * get size.
     * @return -
     */
    public int size() {
        return size;
    }

    /**
     * Positional Access Operations.
     * @param index -
     * @return -
     */
    @SuppressWarnings("unchecked")
    private E container(int index) {
        return (E) container[index];
    }

    /**
     * get element by index.
     * @param index -
     * @return -
     */
    public E get(int index) {
        rangeCheck(index);
        return container(index);
    }

    /**
     * check of range.
     * @param index -
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * increase in dimension.
     */
    private void ensureCapacity() {
        if (size == container.length) {
            container = Arrays.copyOf(container, size * 3 / 2 + 1);
        }
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
}
