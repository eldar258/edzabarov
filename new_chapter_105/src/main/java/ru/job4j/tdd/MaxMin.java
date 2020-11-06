package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getMaxOrMin(value, comparator);
    }
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getMaxOrMin(value, comparator.reversed());
    }

    private <T> T getMaxOrMin(List<T> value, Comparator<T> comparator) {
        T result;
        int length = value.size();
        if (value.size() == 0) result = null;
        else {
            result = value.get(0);
            for (int i = 1; i < length; i++) {
                T el = value.get(i);
                result = comparator.compare(result, el) > 0 ? result : el;
            }
        }
        return result;
    }
}