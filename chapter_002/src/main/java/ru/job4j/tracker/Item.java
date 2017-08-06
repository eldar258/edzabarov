package ru.job4j.tracker;

import java.text.SimpleDateFormat;

/**
 * Class Item.
 *
 * @author edzabarov
 * @since 05.08.2017
 */
public class Item {
    /**
     * id.
     */
    private String id;
    /**
     * name.
     */
    private String name;
    /**
     * desc.
     */
    private String desc;
    /**
     * created.
     */
    private long created;
    /**
     * comments.
     */
    private String[] comments;

    /**
     * Конструктор.
     * @param name - имя
     * @param desc - описание
     * @param created - дата создания
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    /**
     *
     * @param id - id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     *
     * @param name - имя
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @param desc - описание
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     *
     * @param created - дата
     */
    public void setCreated(long created) {
        this.created = created;
    }
    /**
     *
     * @param comments - комментарий
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }
    /**
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }
    /**
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     *
     * @return desc
     */
    public String getDesc() {
        return this.desc;
    }
    /**
     *
     * @return id
     */
    public long getCreated() {
        return this.created;
    }
    /**
     *
     * @return comments
     */
    public String[] getComments() {
        return this.comments;
    }

    /**
     * item to string.
     * @return Name, desc, created, id, comments.
     */
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("YYYY:MM:dd:HH:mm:ss:SSS");
        return "\tName: " + getName() + "\r\n\tDescription: " + getDesc()
                + "\r\n\tDate of creation: " + format.format(getCreated())
                + "\r\n\tId: " + getId() + "\r\n\tComments: " + getComments();
    }
}