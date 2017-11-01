package ru.job4j.set;

import ru.job4j.generic.SimpleArray;
import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ru.job4j.set.
 *
 * @author edzabarov
 * @since 01.11.2017
 */
public class SimpleHashSet<E> implements Iterable<E> {
    private Object[] container;
    private int scopeHashFunDef = 1000;
    private SimpleArrayList<Integer> indices;

    public SimpleHashSet() {
        container = new Object[scopeHashFunDef];
        indices = new SimpleArrayList<>();
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Iterator<Integer> index = indices.iterator();
            @Override
            public boolean hasNext() {
                return index.hasNext();
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return container(index.next());
            }
        };
    }
    public boolean add(E value) {
        if (value == null) return false;
        int hashCode = Math.abs(value.hashCode() % scopeHashFunDef);
        while (container[hashCode] != null) {
            if (value.equals(container(hashCode))) {
                return false;
            } else {
                hashCode++;
                hashCode %= 1000;
            }
        }
        container[hashCode] = value;
        indices.add(hashCode);
        return true;
    }
    @SuppressWarnings("unchecked")
    private E container(int index) {
        return (E) container[index];
    }
}
