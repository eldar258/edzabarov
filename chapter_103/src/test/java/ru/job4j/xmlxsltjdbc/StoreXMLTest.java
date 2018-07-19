package ru.job4j.xmlxsltjdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 16.07.2018
 */
public class StoreXMLTest {
    File target;
    StoreXML storeXML;

    @Before
    public void init() {
        target = new File("src/test/java/ru/job4j/xmlxsltjdbc/StoreXMLTarget.xml");
        storeXML = new StoreXML(target);
    }

    @Test
    public void whenListSaveWhenListSaveInFile() {
            List<StoreXML.Entry> entries = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                StoreXML.Entry entry = new StoreXML.Entry(j);
                entries.add(entry);
            }
        storeXML.save(entries);

        StringBuilder expected = this.readFile(target);
        StringBuilder result = this.readFile(new File("src/test/java/ru/job4j/xmlxsltjdbc/StoreXMLResult.xml"));
        assertThat(expected.toString(), is(result.toString()));
    }

    private StringBuilder readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                sb.append(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb;
    }

    @After
    public void clearFile() {
        try (FileWriter fw = new FileWriter(target)) {
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}