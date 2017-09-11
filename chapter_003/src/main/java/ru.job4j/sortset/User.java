package ru.job4j.sortset;

/**
 * Class User.
 *
 * @author edzabarov
 * @since 09.09.2017
 */
public class User implements Comparable<User> {
    /**
     * name.
     */
    private String name;
    /**
     * age.
     */
    private int age;

    /**
     * Construction.
     * @param name -
     * @param age -
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Construction.
     */
    public User() {
    }

    /**
     * compareTo.
     * @param o -
     * @return 1
     */
   @Override
    public int compareTo(User o) {
       int result = 0;
       if (this.age >= o.age) result++;
       else if (this.age <= o.age) result--;
       return result;
    }

    /**
     * hashCode.
     * @return -
     */
    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (this.name != null ? name.hashCode() : 0);
        return result;
    }

    /**
     * equals.
     * @param o -
     * @return .
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }
    /**
     * get name.
     * @return -
     */
    public String getName() {
        return name;
    }
    /**
     * get age.
     * @return -
     */
    public int getAge() {
        return age;
    }
}
