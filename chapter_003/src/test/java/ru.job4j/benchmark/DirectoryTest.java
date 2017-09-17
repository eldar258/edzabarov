package ru.job4j.benchmark;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class test to Directory class.
 */
public class DirectoryTest {
    /**
     * sortingAscending.
     */
    @Test
    public void whenSortedDirByAscendingWhenDirSortedAscending() {
        Directory dir = new Directory();
        dir.pathWay("K1\\SK1");
        dir.pathWay("K1\\SK2");
        dir.pathWay("K1\\SK1\\SSK1");
        dir.pathWay("K1\\SK1\\SSK2");
        dir.pathWay("K2");
        dir.pathWay("K2\\SK1\\SSK1");
        dir.pathWay("K2\\SK1\\SSK2");
        String[] result = {"K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        assertThat(dir.sortingAscending(), is(result));
    }
    /**
     * sortingDecreasing.
     */
    @Test
    public void whenSortedDirByDecreasingWhenDirSortedDecreasing() {
        Directory dir = new Directory();
        dir.pathWay("K1\\SK1");
        dir.pathWay("K1\\SK2");
        dir.pathWay("K1\\SK1\\SSK1");
        dir.pathWay("K1\\SK1\\SSK2");
        dir.pathWay("K2");
        dir.pathWay("K2\\SK1\\SSK1");
        dir.pathWay("K2\\SK1\\SSK2");
        String[] result = {"K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"};
        assertThat(dir.sortingDecreasing(), is(result));
    }
}
