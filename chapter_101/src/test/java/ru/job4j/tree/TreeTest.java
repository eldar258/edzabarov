package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.tree.
 *
 * @author edzabarov
 * @since 12.12.2017
 */
public class TreeTest {
    @Test
    public void whenValueAddInTreeThenValueAdded() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 1);
        tree.add(1 , 2);
        tree.add(2, 3);
        assertThat(tree.findByValue(3).isPresent(), is(true));
    }
    @Test
    public void whenValueAddInTreeThenNotAddedValueNotAdded() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 1);
        tree.add(1 , 2);
        tree.add(2, 3);
        assertThat(tree.findByValue(4).isPresent(), is(false));
    }
}