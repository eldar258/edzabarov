package ru.job4j.newtracker;

/**
 * Class ru.job4j.newtracker.
 *
 * @author edzabarov
 * @since 08.07.2018
 */
public class Item {
    private int id;
    private String name;
    private String desc;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }
}
