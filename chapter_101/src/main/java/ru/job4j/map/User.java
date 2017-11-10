package ru.job4j.map;

import java.util.Calendar;

/**
 * Class ru.job4j.map.
 *
 * @author edzabarov
 * @since 10.11.2017
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User() {

    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }
}
