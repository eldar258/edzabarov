package ru.job4j.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


public class BinaryTree<E extends Comparable<E>> implements SimpleBinaryTree<E> {

    private Node<E> root;

    @Override
    public boolean add(E value) {
        if (value == null) return false;
        if (root == null) {
            root = new Node<>(value);
            return true;
        }
        search(root, value);
        return true;
    }

    private void search(Node<E> parent, E value) {
        int compareResult = value.compareTo(parent.getValue());
        Node<E> child = (compareResult == 1) ? parent.getRight() : parent.getLeft();
        if (child != null) {
            search(child, value);
        } else {
            child = new Node<E>(value);
            if (compareResult == 1) {
                parent.setRight(child);
            } else parent.setLeft(child);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<E> results = new LinkedList<>();
            private boolean isSorted = false;

            private void sort(Node<E> node, Queue<E> results) {
                if (node.getLeft() != null) sort(node.getLeft(), results);
                results.offer(node.getValue());
                if (node.getRight() != null) sort(node.getRight(), results);
            }

            @Override
            public boolean hasNext() {
                if (!isSorted) {
                    isSorted = true;
                    sort(root, results);
                }
                return !results.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return results.poll();
            }
        };
    }
}
