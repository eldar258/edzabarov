package ru.job4j.benchmark;

import java.util.ArrayList;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 17.09.2017
 */
public class Directory {
    /**
     * head node.
     */
    private Node head;
    /**
     * array of sorted lines for output.
     */
    private ArrayList<String> way;
    /**
     * StringBuilder.
     */
    private StringBuilder sb;

    /**
     * Constructor.
     */
    public Directory() {
        this.head = new Node();
        this.head.setValue("HEAD");
    }
    /**
     * set path.
     * @param value -
     */
    public void pathWay(String value) {
        String[] values = value.split("\\\\");
        Node prev = this.head;
        Node next = null;
        for (String val : values) {
            next = new Node();
            next.setValue(val);
                if (!prev.getNextNodes().add(next)) { //если ел. не был добавлен из-за присутствия похожего эл., присваиваем prev похожий эл.
                for (Node el : prev.getNextNodes()) {
                    if (el.hashCode() == next.hashCode() && el.equals(next)) {
                        prev = el;
                        break;
                    }
                }
            } else {
                prev = next;
            }
        }
    }
    /**
     * get.
     * @return -
     */
    public Node getHead() {
        return head;
    }
    /**
     * sortDirectory.
     * @param cycleFor - implementation of the for loop.
     * @return -
     */
    private String[] sortDirectory(CycleFor cycleFor) {
        way = new ArrayList<>();
        sb = new StringBuilder();
        Node[] nodes = this.head.getNextNodes().toArray(new Node[0]);
        cycleFor.firstFor(nodes);
        String[] result = way.toArray(new String[0]);
        this.way = null;
        this.sb = null;
        return result;
    }

    /**
     * sorting Decreasing.
     * @return -
     */
    public String[] sortingDecreasing() {
        return sortDirectory(new ForDown());
    }

    /**
     * Sort Ascending.
     * @return -
     */
    public String[] sortingAscending() {
        return sortDirectory(new ForUp());
    }

    /**
     * recursive method.
     * @param node -
     * @param cycleFor - implementation of the for loop.
     */
    private void goToWay(Node node, CycleFor cycleFor) {
        if (sb.length() == 0) {
            sb.append(String.format("%s", node.getValue()));
        } else {
            sb.append(String.format("\\%s", node.getValue()));
        }
        way.add(sb.toString());

        if (!node.getNextNodes().isEmpty()) {
            cycleFor.startFor(node.getNextNodes().toArray(new Node[0]));
        }
        try {
            sb.setLength(sb.length() - node.getValue().length() - 1); // удаляется последняя добавленная строка.
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("The first line is found. The deletion did not happen.");
        } //выбрасывается, если удаляемая строка первая.
    }
    /**
     * interface of the for loop.
     */
    private interface CycleFor {
        /**
         * base cycle code.
         * @param nodes -
         */
        void startFor(Node[] nodes);

        /**
         * code for the first Node.
         * @param nodes -
         */
        void firstFor(Node[] nodes);
    }

    /**
     * implementation of the for loop in ascending order.
     */
    private class ForUp implements CycleFor {
        @Override
        public void startFor(Node[] nodes) {
            for (int i = 0; i < nodes.length; i++) {
                goToWay(nodes[i], this);
            }
        }
        @Override
        public void firstFor(Node[] nodes) {
            for (int i = 0; i < nodes.length; i++) {
                goToWay(nodes[i], this);
                sb.setLength(0);
            }
        }
    }

    /**
     * implementation of the for loop in Decreasing order.
     */
    private class ForDown implements CycleFor {
        @Override
        public void startFor(Node[] nodes) {
            for (int i = nodes.length - 1; i >= 0; i--) {
                goToWay(nodes[i], this);
            }
        }
        @Override
        public void firstFor(Node[] nodes) {
            for (int i = nodes.length - 1; i >= 0; i--) {
                goToWay(nodes[i], this);
                sb.setLength(0);
            }
        }
    }
}
