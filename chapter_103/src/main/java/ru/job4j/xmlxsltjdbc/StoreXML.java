package ru.job4j.xmlxsltjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * Class ru.job4j.xmlxsltjdbc.
 *
 * @author edzabarov
 * @since 14.07.2018
 */
public class StoreXML {
    private static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class);

    File target;

    @XmlRootElement
    public static class Entries {
        private List<Entry> entry;

        public void setEntry(List<Entry> entry) {
            this.entry = entry;
        }

        public List<Entry> getEntry() {

            return entry;
        }

        public Entries() {

        }

        public Entries(List<Entry> entry) {

            this.entry = entry;
        }
    }

    @XmlRootElement
    public static class Entry {
        private int field;

        public Entry() {
        }

        public Entry(int field) {
            this.field = field;
        }

        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }
    }


    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(new Entries(list), target);
        } catch (JAXBException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
