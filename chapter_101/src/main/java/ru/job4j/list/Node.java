package ru.job4j.list;

import ru.job4j.generic.SimpleArray;

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

    public boolean hasCycle(Node node) {
        boolean result = false;
        SimpleArrayList<Node> simpleArrayList = new SimpleArrayList<>();
        while (node != null && !result) {
            for (Node el : simpleArrayList) {
                if (node == el) {
                    result = true;
                    break;
                }
            }
            simpleArrayList.add(node);
            node = node.next;
        }
        return result;
    }
}