package ru.job4j.benchmark;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 07.12.2017
 */
public class SimpleSAXParserTest {
    private String path = "src/main/java/ru/job4j/benchmark/orders2.xml";
    private SimpleSAXParser simpleSAXParser = new SimpleSAXParser();
    private Distributor distributor = simpleSAXParser.startParsing(path);

    @Test
    public void whenParseXMLFileThenPrintTable() {
        System.out.println(distributor.createTable());
    }

    @Test
    public void whenInputFromXMLFileParseThenDataCorrespondToOriginal() {
        Map<String, Map<String, Order>> parsingData = distributor.getData();
        Order[] result = {new Order("book-1", "SELL", "100.50", "81", "1"),
                new Order("book-1", "BUY", " 99.70", "16", "3")};
        Order[] expected = {parsingData.get("book-1").get("1"), parsingData.get("book-1").get("3")};
        assertThat(expected, is(result));
    }
}