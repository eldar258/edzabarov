package ru.job4j.binarytree;


public interface SimpleBinaryTree<E extends Comparable<E>> extends Iterable<E> {
    boolean add(E value);
}
