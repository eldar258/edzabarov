package ru.job4j.benchmark;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 07.12.2017
 */
public class SimpleSAXParser {
    public Distributor startParsing(String path) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        Handler handler = new Handler();
        try {
            parser = factory.newSAXParser();
            parser.parse(new File(path), handler);
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            ex.printStackTrace();
        }
        return handler.getDistributor();
    }
}
