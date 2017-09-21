package ru.job4j.benchmarktwo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class Catalog.
 *
 * @author edzabarov
 * @since 21.09.2017
 */
public class Catalog {
    /**
     * Catalog.
     */
    private Map<String, Set<String>> ways = new TreeMap<>();

    /**
     * add string.
     * @param path -
     */
    public void paveWay(String path) {
        String[] nodes = path.split("\\\\");
        Set<String> way = this.ways.get(nodes[0]);
        if (way != null) {
            way.add(nodes[0]);
        } else {
            way = new TreeSet<>();
            way.add(nodes[0]);
            this.ways.put(nodes[0], way);
        }
        pave(way, nodes, 1, nodes[0]);
    }

    /**
     * sorted by Ascending.
     * @return - sorted Array by Ascending.
     */
    public String[] sortCatalogAscending() {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> way : this.ways.entrySet()) {
            result.addAll(Arrays.asList(way.getValue().toArray(new String[0])));
        }
        return result.toArray(new String[0]);
    }

    /**
     * sorted by Decreasing.
     * @return - sorted Array by Decreasing.
     */
    public String[] sortCatalogDecreasing() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Set<String>> temp = new ArrayList<>();
        for (Map.Entry<String, Set<String>> way : this.ways.entrySet()) {
            temp.add(way.getValue());
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length();
                result = result == 0 ? o2.compareTo(o1) : result;
                return result;
            }
        };
        for (int i = temp.size() - 1; i >= 0; i--) {
            TreeSet<String> rez = new TreeSet<>(comparator);
            rez.addAll(Arrays.asList(temp.get(i).toArray(new String[0])));
            result.addAll(Arrays.asList(rez.toArray(new String[0])));
        }
        return result.toArray(new String[0]);
    }

    /**
     * recursive method of adding subdivisions.
     * @param paths - The method parameter for storing all the subdivisions.
     * @param nodes - Input subdivisions.
     * @param i - number subdivisions (starting with 0).
     * @param temp - previous subdivision.
     */
    private void pave(Set<String> paths, String[] nodes, int i, String temp) {
        if (i < nodes.length) {
            temp = String.format("%s\\%s", temp, nodes[i]);
            paths.add(temp);
            pave(paths, nodes, ++i, temp);
        }
    }
}
