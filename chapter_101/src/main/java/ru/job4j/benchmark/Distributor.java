package ru.job4j.benchmark;

import java.util.*;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 07.12.2017
 */
public class Distributor {
    /**
     * first key - name book.
     * second key - id of order.
     */
    private Map<String, Map<String, Order>> data = new HashMap<>();

    public void putOrder(Order order) {
        if (!data.containsKey(order.getBookName())) {
            data.put(order.getBookName(), new HashMap<>());
        }
        data.get(order.getBookName()).put(order.getId(), order);
    }
    public void deleteOrder(String bookName, String orderId) {
        data.get(bookName).remove(orderId);
    }

    public StringBuilder createTable() {
        StringBuilder sb = new StringBuilder();
        Set<String> bookNames = data.keySet();
        for (String bookName : bookNames) {
            addBookInTable(bookName, data.get(bookName), sb);
        }
        return sb;
    }

    private void addBookInTable(String bookName, Map<String, Order> book, StringBuilder sb) {
        Map<Float, Order> buy = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        Map<Float, Order> sell = new TreeMap<>();
        for (Order order : book.values()) {
            Float temp = Float.valueOf(order.getPrice());
            if (order.getOperation().equals("BUY")) {
                buy.put(temp, order);
            } else {
                sell.put(temp, order);
            }
        }

        sb.append("\r\r");
        sb.append(String.format("OrderBook: %s\r\n", bookName));
        sb.append("BID                  ASK\r\n");
        sb.append("Volume@Price – Volume@Price\r\n");

        Iterator<Order> buyIter = buy.values().iterator();
        Iterator<Order> sellIter = sell.values().iterator();
        StringBuilder buyString = new StringBuilder();
        StringBuilder sellString = new StringBuilder();
        while (buyIter.hasNext() || sellIter.hasNext()) {
            buyString.setLength(0);
            sellString.setLength(0);
            stringFormat(buyString, buyIter.hasNext() ? buyIter.next() : null);
            stringFormat(sellString, sellIter.hasNext() ? sellIter.next() : null);
            sb.append(String.format("OrderBook: %s - %s\r\n", buyString, sellString));
        }
        sb.append("\r\n");
    }
    private void stringFormat(StringBuilder builder, Order order) {
        if (order == null) {
            builder.append("-----------    ");
        } else {
            builder.append(String.format("%s@%s", order.getVolume(), order.getPrice()));
        }
    }

    public Map<String, Map<String, Order>> getData() {
        return data;
    }
}
