package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ru.job4j.tree.
 *
 * @author edzabarov
 * @since 12.12.2017
 */
public class Node<E> {
    private List<Node<E>> children = new ArrayList<>();
    private E value;

    public Node(E value) {
        this.value = value;
    }
    public void add(Node<E> child) {
        children.add(child);
    }
    public List<Node<E>> getChildren() {
        return children;
    }
    public boolean equalsValue(E other) {
        return value.equals(other);
    }
    public E getValue() {
        return value;
    }
}
