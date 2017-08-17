package ru.job4j.tracker;

/**
 * Class BaseAction.
 *
 * @author edzabarov
 * @since 17.08.2017
 */
public abstract class BaseAction implements UserAction {
    /**
     * name.
     */
    private String name;
    /**
     * key.
     */
    private int key;

    /**
     * Конструктор.
     * @param name - сообщение об удачном действии.
     * @param key номер муню.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }
    /**
     * key.
     * @return 0
     */
    public int key() {
        return this.key;
    }
    /**
     * execute.
     * @param input -
     * @param tracker -
     */
    public abstract void execute(Input input, Tracker tracker);
    /**
     * возврощает информацию.
     * @return -
     */
    public String info() {
        return String.format("%s. %s", this.key(), name);
    }
}
