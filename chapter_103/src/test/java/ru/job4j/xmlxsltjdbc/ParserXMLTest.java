package ru.job4j.xmlxsltjdbc;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 18.07.2018
 */
public class ParserXMLTest {

    @Test
    public void whenParseFileThenReturnRightNumber() {
        ParserXML parserXML = new ParserXML();
        int expected = parserXML.parse(new File("src/test/java/ru/job4j/xmlxsltjdbc/ConvertXSQTResult.xslt"));
        int result = 10;
        assertThat(expected, is(result));
    }
}