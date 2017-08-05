package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Class Tracker.
 * @author edzabarov
 */
public class Tracker {
    /**
     * items.
     */
    private Item[] items = new Item[100];
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
        this.items[position++] = item;
        return item;
    }
    /**
     * Редактирование заявки.
     * @param item - обновляемый item
     */
    public void update(Item item) {
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
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
            if (this.items[index].getId().equals(item.getId())) {
                Item[] itemsCopy = new Item[position];
                System.arraycopy(this.items, 0, itemsCopy, 0, index);
                System.arraycopy(this.items, index + 1, itemsCopy, index, position - index - 1);
                this.items = itemsCopy;
                position--;
                break;
            }
        }
    }
    /**
     * Получнение списка всех заявок.
     * @return Item[]
     */
    public Item[] getAll() {
        return Arrays.copyOf(this.items, position);
    }
    /**
     * Получение списка по имени.
     * @param key - имя, ключ для поиска
     * @return Item[]
     */
    public Item[] findByName(String key) {
        int numFoundEl = 0;
        Item[] findItems = new Item[position];
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                findItems[numFoundEl++] = items[index];
            }
        }
        return Arrays.copyOf(findItems, numFoundEl);
    }
    /**
     * Получение заявки по Id.
     * @param id - id для поиска
     * @return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                result = items[index];
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
