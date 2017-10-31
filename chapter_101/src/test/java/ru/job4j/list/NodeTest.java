package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.list.
 *
 * @author edzabarov
 * @since 27.10.2017
 */
public class NodeTest {
    private Node<Integer> one = new Node<>(1);
    private Node<Integer> two = new Node<>(2);
    private Node<Integer> three = new Node<>(3);
    private Node<Integer> four = new Node<>(4);
    {
        one.next = two;
        two.next = three;
        three.next = four;
    }

    @Test
    public void whenCyclicListThenHasCycleReturnTrue() {
        four.next = two;
        assertThat(new Node<>(0).hasCycle(two), is(true));
    }

    @Test
    public void whenCyclicListAndFirstNodeNotIncludedInTheCycleThenHasCycleReturnTrue() {
        four.next = two;
        assertThat(new Node<>(0).hasCycle(one), is(true));
    }

    @Test
    public void whenNotCyclicListThenHasCycleReturnFalse() {
        assertThat(new Node<>(0).hasCycle(one), is(false));
    }

}