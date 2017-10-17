package ru.job4j.generic;

/**
 * Class User.
 *
 * @author edzabarov
 * @since 05.10.2017
 */
public class User extends Base {
    /**
     * id.
     */
    private String id;

    @Override
    void setId(String id) {
        this.id = id;
    }

    @Override
    String getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;

    }
}
