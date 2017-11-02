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
        if (node == null || node.next == null) return false;
        Node first = node;
        Node second = node.next;
        while (second != null && second.next != null) {
            if (first == second) {
                result = true;
                break;
            }
            first = first.next;
            second = second.next.next;
        }
        return result;
    }
}