package ru.job4j.binarytree;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class BinaryTreeTest {
    @Test
    public void whenValuesAddThenReturnSortedValues() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(4);
        tree.add(6);
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(7);
        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(3, 4, 4, 5, 6, 7));
        List<Integer> expected = new ArrayList<>();
        for (Integer el : tree) {
            expected.add(el);
        }
        assertThat(expected, is(result));
    }
}