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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (bookName != null ? !bookName.equals(order.bookName) : order.bookName != null) return false;
        if (operation != null ? !operation.equals(order.operation) : order.operation != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        return volume != null ? volume.equals(order.volume) : order.volume == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        return result;
    }
}
