package ru.job4j.bank;

/**
 * Class User.
 *
 * @author edzabarov
 * @since 14.09.2017
 */
public class User {
    /**
     *  passport data.
     */
    private String passport;
    /**
     * name.
     */
    private String name;

    /**
     * Constructor.
     * @param passport -
     * @param name -
     */
    public User(String passport, String name) {
        this.passport = passport;
        this.name = name;
    }

    /**
     * equals.
     * @param o -
     * @return -
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return passport != null ? passport.equals(user.passport) : user.passport == null;

    }

    /**
     * hashCode.
     * @return -
     */
    @Override
    public int hashCode() {
        return passport != null ? passport.hashCode() : 0;
    }
}
