package ru.job4j.notyfyall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class ru.job4j.notyfyall.
 *
 * @author edzabarov
 * @since 28.03.2018
 */
public class ParallerSearchTest {
    @Test
    public void whenDataInputThenFilesFound() {
        List<String> extx = new ArrayList<>();
        extx.add("java");
        extx.add("txt");
        String root = "";
        String text = "";
        ParallerSearch parallerSearch = new ParallerSearch(root, text, extx);
        List<String> expected = parallerSearch.result();
        expected.forEach(System.out::println);
    }
}