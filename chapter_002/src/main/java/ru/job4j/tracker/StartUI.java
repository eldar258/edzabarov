package ru.job4j.tracker;

/**
 * Class main class, Отображение меню.
 *
 * @author edzabarov
 * @since 06.08.2017
 */
public class StartUI {
    /**
     * input.
     */
    private Input input;
    /**
     * add().
     */
    private static final String ADD = "0";
    /**
     * getAll().
     */
    private static final String SHOW_ALL_ITEMS = "1";
    /**
     * update().
     */
    private static final String EDIT_ITEM = "2";
    /**
     * delete().
     */
    private static final String DELETE_ITEM = "3";
    /**
     * findById().
     */
    private static final String FIND_ITEM_BY_ID = "4";
    /**
     * findByName().
     */
    private static final String FIND_ITEMS_BY_NAME = "5";
    /**
     * exit program.
     */
    private static final String EXIT_PROGRAM = "6";
    /**
     * menu ui.
     */
    private String menuUi = "ERROR";
    /**
     * tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * Конструктор.
     * @param input - input.
     */
    public StartUI(Input input) {
        String[] menuUiArray = {
                "0. Add new Item",
                "1. Show all items",
                "2. Edit item",
                "3. Delete item",
                "4. Find item by Id",
                "5. Find items by name",
                "6. Exit Program",
                "Select:"
        };
        this.menuUi = String.join("\r\n", menuUiArray);
        this.input = input;
    }
    /**
     * Конструктор основной.
     * @param input - input.
     * @param tracker - tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this(input);
        this.tracker = tracker;
    }
    /**
     * main.
     * @param args - args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).start();
    }

    /**
     * Запускает цикл постоянного ввода.
     */
    public void start() {
        while (distributor()) {
            continue;
        }
    }

    /**
     * Распределитель.
     * @return false в случае выхода из программы, иначе true
     */
    private boolean distributor() {
        boolean isNotExit = true;
        switch (input.ask(String.join("", this.menuUi))) {
            case ADD:
                add();
                break;
            case SHOW_ALL_ITEMS:
                showAllItems();
                break;
            case EDIT_ITEM:
                editItem();
                break;
            case DELETE_ITEM:
                deleteItem();
                break;
            case FIND_ITEM_BY_ID:
                findItemById();
                break;
            case FIND_ITEMS_BY_NAME:
                findItemsByName();
                break;
            case EXIT_PROGRAM:
                isNotExit = false;
                break;
           default:
                System.out.println("Error: command not found.");
        }
        return isNotExit;
    }
    /**
     * add.
     */
    private void add() {
            tracker.add(new Item(input.ask("Enter name: "), input.ask("Enter description: "), System.currentTimeMillis()));
            System.out.println("Item successfully added");
    }
    /**
     * showAllItems.
     */
    private void showAllItems() {
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
     * editItem.
     */
    private void editItem() {
        Item item = new Item(input.ask("Enter of the item being updated: "),
                input.ask("Enter description of the item being updated: "), System.currentTimeMillis());
        item.setId(input.ask("Enter id of the item being updated:"));
        tracker.update(item);
        System.out.println("Item successfully updated");
    }

    /**
     * deleteItem.
     */
    private void deleteItem() {
        Item item = new Item();
        item.setId(input.ask("Enter id of the item being deleted:"));
        tracker.delete(item);
        System.out.println("Item successfully deleted");
    }
    /**
     * findItemById.
     */
    private void findItemById() {
        Item item = tracker.findById(input.ask("Enter item id to be find:"));
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Item not found");
        }
    }
    /**
     * findItemsByName.
     */
    private void findItemsByName() {
        Item[] items = tracker.findByName(input.ask("Enter item name to be find:"));
        if (items.length != 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Items not found");
        }
    }
}