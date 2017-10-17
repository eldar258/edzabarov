package ru.job4j.generic;

/**
 * Class ru.job4j.generic.
 *
 * @author edzabarov
 * @since 17.10.2017
 */
public class RoleStore implements Store<Role> {
    /**
     *  simple array.
     */
    private SimpleArray<Role> simpleArray;

    /**
     * userStore.
     */
    public RoleStore() {
        simpleArray = new SimpleArray<>();
    }
    @Override
    public Role add(Role value) {
        return simpleArray.add(value);
    }
    @Override
    public Role update(Role value) {
        return simpleArray.update(value);
    }
    @Override
    public boolean delete(Role value) {
        return simpleArray.delete(value);
    }
}
