package ru.job4j.tracker;

/**
 * Class UserAction.
 *
 * @author edzabarov
 * @since 12.08.2017
 */
public interface UserAction {
    /**
     * key.
     * @return 0
     */
    int key();

    /**
     * execute.
     * @param input -
     * @param tracker -
     */
    void execute(Input input, Tracker tracker);
    /**
     * info.
     * @return - info.
     */
    String info();
}
