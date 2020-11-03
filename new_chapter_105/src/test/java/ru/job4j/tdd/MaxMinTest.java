package ru.job4j.tdd;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void whenMaxAndListExistOneElThenReturnThisEl() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = new ArrayList<>();
        int result = 100;
        list.add(result);
        Integer resultMax = maxMin.max(list, Integer::compareTo);
        assertThat(resultMax, is(result));
    }
    @Test
    public void whenMaxAndListExistTwoElThenReturnMax() {
        MaxMin maxMin = new MaxMin();
        Integer[] array = {1, 99};
        Integer[] array2 = {99, 1};
        int resultMax = 99;
        int resultMin = 1;
        List<Integer> list = Arrays.asList(array);
        List<Integer> list2 = Arrays.asList(array2);
        Integer targetMax = maxMin.max(list, Integer::compareTo);
        Integer targetMin = maxMin.min(list, Integer::compareTo);
        Integer targetMax2 = maxMin.max(list2, Integer::compareTo);
        Integer targetMin2 = maxMin.min(list2, Integer::compareTo);
        assertThat(targetMax, is(resultMax));
        assertThat(targetMin, is(resultMin));
        assertThat(targetMax2, is(resultMax));
        assertThat(targetMin2, is(resultMin));
    }
    @Test
    public void whenMaxAndMinAndListExistMoreTwoElThenReturn14AndMinus1() {
        MaxMin maxMin = new MaxMin();
        Integer[] array = {1, 2, 3, 4, 2, 5, 1, 6, 6, 14, 0, 1, -1};
        int resultMax = 14;
        int resultMin = -1;
        List<Integer> list = Arrays.asList(array);
        Integer targetMax = maxMin.max(list, Integer::compareTo);
        Integer targetMin = maxMin.min(list, Integer::compareTo);
        assertThat(targetMax, is(resultMax));
        assertThat(targetMin, is(resultMin));
    }
}