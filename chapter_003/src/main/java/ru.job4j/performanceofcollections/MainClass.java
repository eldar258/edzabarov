package ru.job4j.performanceofcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Class mainclass.
 *
 * @author edzabarov
 * @since 31.08.2017
 */
public class MainClass {
    /**
     * main.
     * @param args -
     */
    public static void main(String[] args) {
        Collection<String> ll = new LinkedList();
        Collection<String> al = new ArrayList();
        Collection<String> ts = new TreeSet<>();
        Performance performance = new Performance();
        int numEl = 100000;
        System.out.println(performance.add(ll, numEl));
        System.out.println(performance.add(al, numEl));
        System.out.println(performance.add(ts, numEl));
        System.out.println();
        System.out.println(performance.delete(ll, numEl));
        System.out.println(performance.delete(al, numEl));
        System.out.println(performance.delete(ts, numEl));
//        System.out.println("LinkedList");
//        for (String str : ll) {
//            System.out.println(str);
//        }
//        System.out.println("ArrayList");
//        for (String str : al) {
//            System.out.println(str);
//        }
//        System.out.println("TreeSet");
//        for (String str : ts) {
//            System.out.println(str);
//        }
    }
}
