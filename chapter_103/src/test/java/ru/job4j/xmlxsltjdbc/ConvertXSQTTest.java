package ru.job4j.xmlxsltjdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 18.07.2018
 */
public class ConvertXSQTTest {
    private File source;
    private File dest;
    private ConvertXSQT convertXSQT;

    @Before
    public void init() {
        source = new File("src/test/java/ru/job4j/xmlxsltjdbc/StoreXMLResult.xml");
        dest = new File("src/test/java/ru/job4j/xmlxsltjdbc/ConvertXSQTExpected.xslt");
        convertXSQT = new ConvertXSQT();
    }

    @Test
    public void whenConvertThenConvertRight() {
        convertXSQT.convert(source, dest, new File("src/test/java/ru/job4j/xmlxsltjdbc/scheme.xsl"));

        StringBuilder expected = this.readFile(dest);
        StringBuilder result = this.readFile(new File("src/test/java/ru/job4j/xmlxsltjdbc/ConvertXSQTResult.xslt"));
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
        try (FileWriter fw = new FileWriter(dest)) {
            fw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}