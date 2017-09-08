package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class Tracker.
 * @author edzabarov
 */
public class Tracker {
    /**
     * items.
     */
    private ArrayList<Item> items = new ArrayList();
    /**
     * position.
     */
    private int position = 0;
    /**
     * random generator.
     */
    private static final Random RN = new Random();

    /**
     * Добавление заявки.
     * @param item - добавляемый item
     * @return Item
     */
    public Item add(Item item) {
        item.setId(Tracker.generateId());
        position++;
        this.items.add(item);
        return item;
    }
    /**
     * Редактирование заявки.
     * @param item - обновляемый item
     */
    public void update(Item item) {
        for (int index = 0; index < position; index++) {
            if (this.items.get(index).getId().equals(item.getId())) {
                this.items.set(index, item);
                break;
            }
        }
    }
    /**
     * Удаление заявки.
     * @param item - item, id которго соответсвует удалямуму item
     */
    public void delete(Item item) {
        for (int index = 0; index < position; index++) {
            if (this.items.get(index).getId().equals(item.getId())) {
                this.items.remove(index);
                break;
            }
        }
    }
    /**
     * Получнение списка всех заявок.
     * @return Item[]
     */
    public List<Item> getAll() {
        return (List<Item>) this.items.clone();
    }
    /**
     * Получение списка по имени.
     * @param key - имя, ключ для поиска
     * @return Item[]
     */
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        this.items.forEach((Item itm) -> {
            if (itm.getName().equals(key)) {
                list.add(itm);
            }
        });
        return list;
    }
    /**
     * Получение заявки по Id.
     * @param id - id для поиска
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item itm : this.items) {
            if (itm.getId().equals(id)) {
                result = itm;
                break;
            }
        }
        return result;
    }
    /**
     * Генерация id.
     * @return id
     */
    private static String generateId() {
        return  String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
