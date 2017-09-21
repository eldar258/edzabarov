package ru.job4j.benchmarktwo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class test.
 *
 * @author edzabarov
 * @since 21.09.2017
 */
public class CatalogTest {
    /**
     * sortingAscending.
     */
    @Test
    public void whenSortedCatalogByAscendingWhenCatalogSortedAscending() {
        Catalog cat = new Catalog();
        cat.paveWay("K1\\SK1");
        cat.paveWay("K1\\SK2");
        cat.paveWay("K1\\SK1\\SSK1");
        cat.paveWay("K1\\SK1\\SSK2");
        cat.paveWay("K2");
        cat.paveWay("K2\\SK1\\SSK1");
        cat.paveWay("K2\\SK1\\SSK2");
        String[] result = {"K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        assertThat(cat.sortCatalogAscending(), is(result));
    }
    /**
     * sortingDecreasing.
     */
    @Test
    public void whenSortedCatalogByDecreasingWhenCatalogSortedDecreasing() {
        Catalog cat = new Catalog();
        cat.paveWay("K1\\SK1");
        cat.paveWay("K1\\SK2");
        cat.paveWay("K1\\SK1\\SSK1");
        cat.paveWay("K1\\SK1\\SSK2");
        cat.paveWay("K2");
        cat.paveWay("K2\\SK1\\SSK1");
        cat.paveWay("K2\\SK1\\SSK2");
        String[] result = {"K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"};
        assertThat(cat.sortCatalogDecreasing(), is(result));
    }
}
