package ru.job4j.generic;

/**
 * Class user store.
 *
 * @author edzabarov
 * @since 05.10.2017
 */
public class UserStore implements  Store<User> {
    /**
     *  simple array.
     */
    private SimpleArray<User> simpleArray;

    /**
     * userStore.
     */
    public UserStore() {
        simpleArray = new SimpleArray<>();
    }
    @Override
    public User add(User value) {
        return simpleArray.add(value);
    }
    @Override
    public User update(User value) {
        return simpleArray.update(value);
    }
    @Override
    public boolean delete(User value) {
        return simpleArray.delete(value);
    }
}
