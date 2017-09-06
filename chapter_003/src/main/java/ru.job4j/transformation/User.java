package ru.job4j.transformation;

/**
 * Class User.
 *
 * @author edzabarov
 * @since 06.09.2017
 */
public class User {
    /**
     * id.
     */
    private int id;
    /**
     * name.
     */
    private String name;
    /**
     * city.
     */
    private String city;

    /**
     * getAndSet.
     * @return -
     */
    public String getName() {
        return name;
    }

    /**
     * getAndSet.
     * @param name -
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getAndSet.
     * @return -
     */
    public String getCity() {
        return city;
    }
    /**
     * getAndSet.
     * @param city -
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * getAndSet.
     * @return -
     */
    public int getId() {
        return id;
    }
    /**
     * getAndSet.
     * @param id -
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return city != null ? city.equals(user.city) : user.city == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
