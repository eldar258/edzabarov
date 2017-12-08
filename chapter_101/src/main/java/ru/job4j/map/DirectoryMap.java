package ru.job4j.map;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

/**
 * Class ru.job4j.map.
 *
 * @author edzabarov
 * @since 14.11.2017
 */
public class DirectoryMap<K, V> implements Iterable<V> {
    private Object[] container;
    private int scopeHashFunDef;
    private LinkedHashSet<Integer> indices;

    public DirectoryMap(int scopeHashFunDef) {
        this.scopeHashFunDef = scopeHashFunDef;
        container = new Object[this.scopeHashFunDef];
        indices = new LinkedHashSet<>();
    }

    public DirectoryMap() {
        this(1000);
    }
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private Iterator<Integer> index = indices.iterator();
            @Override
            public boolean hasNext() {
                return index.hasNext();
            }

            @Override
            public V next() {
                if (!hasNext()) throw new NoSuchElementException();
                return container(index.next());
            }
        };
    }
    public boolean put(K key, V value) {
        boolean result = true;
        if (key == null) return false;
        int hashCode = Math.abs(key.hashCode() % scopeHashFunDef);
        if (container[hashCode] != null && container[hashCode].equals(value)) {
            result = false;
        } else {
            container[hashCode] = value;
            indices.add(hashCode);
        }
        return result;
    }
    public boolean delete(K key) {
        int hashCode = Math.abs(key.hashCode() % scopeHashFunDef);
        boolean result = container[hashCode] == null;
        container[hashCode] = null;
        indices.remove(hashCode);
        return result;
    }
    public V get(K key) {
        return key == null ? null : container(Math.abs(key.hashCode() % scopeHashFunDef));
    }

    @SuppressWarnings("unchecked")
    private V container(int index) {
        return (V) container[index];
    }
}
