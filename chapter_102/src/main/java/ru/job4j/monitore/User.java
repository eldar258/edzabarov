package ru.job4j.monitore;

/**
 * Class ru.job4j.monitore.
 *
 * @author edzabarov
 * @since 26.02.2018
 */
public class User {
    private int id;
    private int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public synchronized void addAmount(int amount) {
        this.amount += amount;
    }

}
