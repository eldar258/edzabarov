package ru.job4j.generic;

/**
 * Class ru.job4j.generic.
 *
 * @author edzabarov
 * @since 17.10.2017
 */
public class Role extends Base {
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
}
