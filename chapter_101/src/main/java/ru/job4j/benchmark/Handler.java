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
    private static final String ADD_ORDER = "AddOrder";
    private static final String DELETE_ORDER = "DeleteOrder";

    private static final String NAME_BOOK = "book";
    private static final String NAME_OPERATION = "operation";
    private static final String PRICE = "price";
    private static final String VOLUME = "volume";
    private static final String ORDER_ID = "orderId";

    private Distributor distributor = new Distributor();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(s, s1, s2, attributes);
        if (qName.equals(ADD_ORDER)) {
            Order order = new Order(attributes.getValue(NAME_BOOK), attributes.getValue(NAME_OPERATION),
                    attributes.getValue(PRICE), attributes.getValue(VOLUME), attributes.getValue(ORDER_ID));
            distributor.putOrder(order);
        } else if (qName.equals(DELETE_ORDER)) {
            distributor.deleteOrder(attributes.getValue(NAME_BOOK), attributes.getValue(ORDER_ID));
        }
    }
    public Distributor getDistributor() {
        return this.distributor;
    }
}
