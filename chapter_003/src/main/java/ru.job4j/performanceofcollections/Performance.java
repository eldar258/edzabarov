package ru.job4j.performanceofcollections;

import java.util.Collection;

/**
 * Class performance of collection.
 *
 * @author edzabarov
 * @since 31.08.2017
 */
public class Performance {
    /**
     * random.
     */
    private int randomTemp = 100;
    /**
     * add random string in collection.
     * @param collection -
     * @param amount - number of random element.
     * @return time.
     */
    public long add(Collection<String> collection, int amount) {
        long time = System.currentTimeMillis();
        for (int i = 1; i <= amount; i++) {
            collection.add(String.format("%s", (int) (Math.random() * randomTemp)));
        }
        return System.currentTimeMillis() - time;
    }
    /**
     * delete random string in collection.
     * @param collection -
     * @param amount - number of random element.
     * @return time.
     */
    public long delete(Collection<String> collection, int amount) {
        long time = System.currentTimeMillis();
        for (int i = 1; i <= amount; i++) {
            collection.remove(String.format("%s", (int) (Math.random() * randomTemp)));
        }
        return System.currentTimeMillis() - time;
    }
}
