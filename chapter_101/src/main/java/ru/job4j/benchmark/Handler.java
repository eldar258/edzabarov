package ru.job4j.benchmark;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 07.12.2017
 */
public class Handler extends DefaultHandler {

    private Distributor distributor = new Distributor();

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        //super.startElement(s, s1, s2, attributes);
        if (s2.equals("AddOrder")) {
            Order order = new Order(attributes.getValue(0), attributes.getValue(1), attributes.getValue(2), attributes.getValue(3), attributes.getValue(4));
            distributor.putOrder(order);
        } else if (s2.equals("DeleteOrder")) {
            distributor.deleteOrder(attributes.getValue(0), attributes.getValue(1));
        }
    }
    public Distributor getDistributor() {
        return this.distributor;
    }
}
