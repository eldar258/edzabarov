package ru.job4j.benchmark;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 07.12.2017
 */
public class Order {
    private String id;
    private String bookName;
    private String operation;
    private String price;
    private String volume;

    public Order(String bookName, String operation, String price, String volume, String id) {
        this.id = id;
        this.bookName = bookName;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getOperation() {
        return operation;
    }

    public String getPrice() {
        return price;
    }

    public String getVolume() {
        return volume;
    }
}
