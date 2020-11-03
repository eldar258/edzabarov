package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getMaxOrMin(value, comparator, 1);
    }
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getMaxOrMin(value, comparator, -1);
    }

    private <T> T getMaxOrMin(List<T> value, Comparator<T> comparator, int maxOrMin) {
        int maxIndex = value.size() - 1;
        return maxIndex == 0 ? value.get(0)
                : calculate(maxOrMin, value, comparator, 0, maxIndex / 2, maxIndex);
    }
    private <T> T calculate(int maxOrMin, List<T> value, Comparator<T> comparator, int leftStart, int rightStart, int finish) {
        T el1 = leftStart == rightStart ? value.get(leftStart)
                : calculate(maxOrMin, value, comparator, leftStart, (leftStart + rightStart) / 2, rightStart);
        T el2 = rightStart + 1 == finish ? value.get(finish)
                : calculate(maxOrMin, value, comparator,rightStart + 1, (finish + rightStart) / 2, finish);
        return maxOrMin * comparator.compare(el1, el2) > 0 ? el1 : el2;
    }
}