package ru.job4j.benchmark;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 07.12.2017
 */
public class SimpleSAXParserTest {
    String path = "src/main/java/ru/job4j/benchmark/orders2.xml";

    @Test
    public void whenParseXMLFileThenPrintTable() {
        SimpleSAXParser simpleSAXParser = new SimpleSAXParser();
        Distributor distributor = simpleSAXParser.startParsing(path);
        System.out.println(distributor.createTable());
    }
}