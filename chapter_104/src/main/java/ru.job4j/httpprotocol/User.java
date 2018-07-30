package ru.job4j.httpprotocol;

import java.util.Date;

/**
 * Class ru.job4j.httpprotocol.
 *
 * @author edzabarov
 * @since 28.07.2018
 */
public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private Date createDate;

    public User(int id, String name, String login, String email, Date createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    public User(String name) {
        this(name.hashCode(), name, name, "no", new Date());
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!name.equals(user.name)) return false;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", id, name, login, email, createDate);
    }
}
