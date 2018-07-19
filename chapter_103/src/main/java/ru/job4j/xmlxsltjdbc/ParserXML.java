package ru.job4j.xmlxsltjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import java.io.File;
import java.io.IOException;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 14.07.2018
 */
public class ParserXML {
    private static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class);

    public int parse(File target) {
        int result = 0;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse(target, handler);
            result = handler.getNum();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    private class Handler extends DefaultHandler {
        private int num = 0;

        public int getNum() {
            return num;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                String value = attributes.getValue("href");
                this.num += Integer.parseInt(value);
            }
        }
    }
}
