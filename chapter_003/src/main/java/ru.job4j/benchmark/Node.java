package ru.job4j.benchmark;

import java.util.Set;
import java.util.TreeSet;

/**
 * Class Node.
 *
 * @author edzabarov
 * @since 17.09.2017
 */
public class Node implements Comparable<Node> {
    /**
     * value.
     */
    private String value;
    /**
     * next nodes.
     */
    private Set<Node> nextNodes = new TreeSet<>();

    /**
     * set.
     * @param value -
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * get.
     * @return -
     */
    public String getValue() {
        return value;
    }
    /**
     * get.
     * @return -
     */
    public Set<Node> getNextNodes() {
        return nextNodes;
    }

    /**
     * equals only values.
     * @param o -
     * @return -
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value != null ? value.equals(node.value) : node.value == null;

    }

    /**
     * calculate hashCode only by values.
     * @return -
     */
    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    /**
     * compareTo only by values.
     * @param o -
     * @return -
     */
    @Override
    public int compareTo(Node o) {
        return this.getValue().compareTo(o.getValue());
    }
}
