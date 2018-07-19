package ru.job4j.xmlxsltjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 14.07.2018
 */
public class ConvertXSQT {
    private static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class);

    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (TransformerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
