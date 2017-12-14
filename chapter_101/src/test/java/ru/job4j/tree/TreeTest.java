package ru.job4j.tree;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.tree.
 *
 * @author edzabarov
 * @since 12.12.2017
 */
public class TreeTest {
    Tree<Integer> tree;

    private void createData() {
        tree = new Tree<>(1);
        tree.add(1, 1);
        tree.add(1, 2);
        tree.add(2, 3);
    }

    @Test
    public void whenValueAddInTreeThenValueAdded() {
        createData();
        assertThat(tree.findByValue(3).isPresent(), is(true));
    }
    @Test
    public void whenValueAddInTreeThenNotAddedValueNotAdded() {
        createData();
        assertThat(tree.findByValue(4).isPresent(), is(false));
    }
    @Test
    public void whenValueAddInTreeThenIteratorReturnAllValues() {
        createData();
        tree.add(1, 1);
        tree.add(1, 1);
        tree.add(1, 1);
        tree.add(4, 5);
        List<Integer> expected = new ArrayList<>();
        for (Integer el : tree) {
            expected.add(el);
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(1, 2, 3));
        assertThat(expected, is(result));
    }
    @Test
    public void whenTreeIsBinaryThenReturnTrue() {
        createData();
        assertThat(tree.isBinary(), is(true));
    }
    @Test
    public void whenTreeIsNotBinaryThenReturnFalse() {
        createData();
        tree.add(1, 4);
        tree.add(1, 5);
        assertThat(tree.isBinary(), is(false));
    }
}