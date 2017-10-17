package ru.job4j.generic;

/**
 * Interface Store.
 *
 * @author edzabarov
 * @since 05.10.2017
 * @param <T> -
 */
public interface Store<T extends Base> {
    /**
     * add.
     * @param model -
     * @return -
     */
    T add(T model);

    /**
     * update.
     * @param model -
     * @return -
     */
    T update(T model);

    /**
     * delete.
     * @param model -
     * @return -
     */
    boolean delete(T model);
}
