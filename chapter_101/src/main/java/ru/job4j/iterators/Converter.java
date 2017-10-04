package ru.job4j.iterators;

import java.util.Iterator;

/**
 * Class sequence of iterators values.
 *
 * @author edzabarov
 * @since 05.10.2017
 */
public class Converter {
    /**
     * convert Iterator<Iterator<Integer>> in Iterator<Integer>.
     * @param it -
     * @return -
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                if (!iterator.hasNext() && it.hasNext()) iterator = it.next();
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!iterator.hasNext()) iterator = it.next();
                return iterator.next();
            }
        };
    }
}
