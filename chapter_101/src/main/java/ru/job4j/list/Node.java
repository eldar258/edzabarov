package ru.job4j.list;

import java.util.HashSet;

/**
 * Class Node.
 *
 * @author edzabarov
 * @since 27.10.2017
 * @param <T> - Generic
 */
public class Node<T> {
    private T value;
    public Node next;

    public Node(T value) {
        this.value = value;
    }

    boolean hasCycle(Node node) {
        boolean result = true;
        HashSet<Node> hashSet = new HashSet<>();
        while (node != null && result) {
            result = hashSet.add(node);
            node = node.next;
        }
        return !result;
    }
}
