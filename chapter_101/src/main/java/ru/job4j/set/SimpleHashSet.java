package ru.job4j.set;

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
    private int scopeHashFunDef;
    private SimpleArrayList<Integer> indices;

    public SimpleHashSet(int scopeHashFunDef) {
        this.scopeHashFunDef = scopeHashFunDef;
        container = new Object[this.scopeHashFunDef];
        indices = new SimpleArrayList<>();
    }

    public SimpleHashSet() {
        this(1000);
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
        boolean result = true;
        if (value == null) return false;
        int hashCode = Math.abs(value.hashCode() % scopeHashFunDef);
        int hashcodeTemp = hashCode;
        while (container[hashCode] != null) {
            if (value.equals(container(hashCode))) {
                result = false;
                break;
            } else {
                hashCode++;
                hashCode %= scopeHashFunDef;
                if (hashcodeTemp == hashCode) {
                    result = false;
                    break;
                }
            }
        }
        if (result) {
            container[hashCode] = value;
            indices.add(hashCode);
            result = true;
        }
        return result;
    }
    @SuppressWarnings("unchecked")
    private E container(int index) {
        return (E) container[index];
    }
}
