package ru.job4j.tree;


import java.util.*;

/**
 * Class ru.job4j.tree.
 *
 * @author edzabarov
 * @since 21.11.2017
 */
class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E valueRoot) {
        root = new Node<>(valueRoot);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findByValue(parent);
        if (parentNode.isPresent()) {
            parentNode.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findByValue(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.equalsValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<E> child : el.getChildren()) {
                    data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}