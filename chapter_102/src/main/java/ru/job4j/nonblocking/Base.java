package ru.job4j.nonblocking;

/**
 * Class ru.job4j.nonblocking.
 *
 * @author edzabarov
 * @since 01.06.2018
 */
public class Base {
    private String userName;
    private int version;
    private int id = (int) System.currentTimeMillis();

    public Base(String userName, int version) {
        this.userName = userName;
        this.version = version;
    }

    public String getUserName() {
        return userName;
    }

    public int getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
