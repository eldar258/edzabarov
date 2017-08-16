package ru.job4j.tracker;

/**
 * Class ru.job4j.tracker.
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
    private UserAction[] actions = new UserAction[6];

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
        this.actions[0] = this.new AddItem();
        this.actions[1] = this.new ShowAllItems();
        this.actions[2] = this.new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindItemById();
        this.actions[5] = this.new FindItemsByName();
    }
    /**
     * show menu.
     */
    public void show() {
        for (int i = 0; i < this.actions.length; i++) {
            System.out.println(this.actions[i].info());
        }
    }

    /**
     * select.
     * @param key -
     */
    public void select(int key) {
            this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * class UserAction.
     */
    private class AddItem implements UserAction {
        /**
         * key.
         * @return 0
         */
        public int key() {
            return 0;
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
        /**
         * info.
         * @return - info.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }
    /**
     * class UserAction.
     */
    private class ShowAllItems implements UserAction {
        /**
         * key.
         * @return 1
         */
        public int key() {
            return 1;
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.getAll();
            if (items.length != 0) {
                for (Item item : items) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("There are no items");
            }
        }
        /**
         * info.
         * @return - info.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
    /**
     * class UserAction.
     */
    private class EditItem implements UserAction {
        /**
         * key.
         * @return 2
         */
        public int key() {
            return 2;
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
        /**
         * info.
         * @return - info.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }
    /**
     * class UserAction.
     */
    private class DeleteItem implements UserAction {
        /**
         * key.
         * @return 3
         */
        public int key() {
            return 3;
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
        /**
         * info.
         * @return - info.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }
    /**
     * class UserAction.
     */
    private class FindItemById implements UserAction {
        /**
         * key.
         * @return 4
         */
        public int key() {
            return 4;
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
        /**
         * info.
         * @return - info.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }
    /**
     * class UserAction.
     */
    private class FindItemsByName implements UserAction {
        /**
         * key.
         * @return 5
         */
        public int key() {
            return 5;
        }
        /**
         * execute.
         * @param input -
         * @param tracker -
         */
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findByName(input.ask("Enter item name to be find:"));
            if (items.length != 0) {
                for (Item item : items) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Items not found");
            }
        }
        /**
         * info.
         * @return - info.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
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
