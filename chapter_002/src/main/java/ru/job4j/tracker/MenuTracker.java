package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ru.ru.job4j.tracker.
 *
 * @author edzabarov
 * @since 12.08.2017
 */
public class MenuTracker {
    /**
     * ranges.
     */
    private int[] ranges = {0, 1, 2, 3, 4, 5, 6};
    /**
     * input.
     */
    private Input input;
    /**
     * tracker.
     */
    private Tracker tracker;
    /**
     * UserAction.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * Construction.
     * @param input -
     * @param tracker -
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * fillAction.
     */
    public void fillAction() {
        this.actions.add(this.new AddItem("Add item.", 0));
        this.actions.add(this.new ShowAllItems("Show all items.", 1));
        this.actions.add(this.new EditItem("Edit item.", 2));
        this.actions.add(this.new DeleteItem("Delete item.", 3));
        this.actions.add(this.new FindItemById("Find item by ID.", 4));
        this.actions.add(this.new FindItemsByName("Find items by name.", 5));
    }
    /**
     * show menu.
     */
    public void show() {
        this.actions.forEach(userAction -> System.out.print(userAction.info()));
    }

    /**
     * select.
     * @param key -
     */
    public void select(int key) {
            this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * class UserAction.
     */
    private class AddItem extends BaseAction {
        /**
         * Конструктор.
         * @param name -
         * @param key -
         */
        private AddItem(String name, int key) {
            super(name, key);
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            tracker.add(new Item(input.ask("Enter name: "), input.ask("Enter description: "), System.currentTimeMillis()));
            System.out.println("Item successfully added");
        }
    }
    /**
     * class UserAction.
     */
    private class ShowAllItems extends BaseAction {
        /**
         * Конструктор.
         * @param name -
         * @param key -
         */
        private ShowAllItems(String name, int key) {
            super(name, key);
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            List<Item> items = tracker.getAll();
            if (items != null) {
                items.forEach(System.out::println);
            } else {
                System.out.println("There are no items");
            }
        }
    }
    /**
     * class UserAction.
     */
    private class EditItem extends BaseAction {
        /**
         * Конструктор.
         * @param name -
         * @param key -
         */
        private EditItem(String name, int key) {
            super(name, key);
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            Item item = new Item(input.ask("Enter of the item being updated: "),
                    input.ask("Enter description of the item being updated: "), System.currentTimeMillis());
            item.setId(input.ask("Enter id of the item being updated:"));
            tracker.update(item);
            System.out.println("Item successfully updated");
        }
    }
    /**
     * class UserAction.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Конструктор.
         * @param name -
         * @param key -
         */
        private DeleteItem(String name, int key) {
            super(name, key);
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            Item item = new Item();
            item.setId(input.ask("Enter id of the item being deleted:"));
            tracker.delete(item);
            System.out.println("Item successfully deleted");
        }
    }
    /**
     * class UserAction.
     */
    private class FindItemById extends BaseAction {
        /**
         * Конструктор.
         * @param name -
         * @param key -
         */
        private FindItemById(String name, int key) {
            super(name, key);
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Enter item id to be find:"));
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * class UserAction.
     */
    private class FindItemsByName extends BaseAction {
        /**
         * Конструктор.
         * @param name -
         * @param key -
         */
        private FindItemsByName(String name, int key) {
            super(name, key);
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            List<Item> items = tracker.findByName(input.ask("Enter item name to be find:"));
            if (items != null) {
                items.forEach(System.out::println);
            } else {
                System.out.println("Items not found");
            }
        }
    }

    /**
     * ranges.
     * @return -
     */
    public int[] getRanges() {
        return ranges;
    }
}
