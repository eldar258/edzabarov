package ru.job4j.tracker;

/**
 * Class main class, Отображение меню.
 *
 * @author edzabarov
 * @since 06.08.2017
 */
public class StartUi {
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
     * create menu UI.
     */
    private StartUi() {
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
    }
    /**
     * main.
     * @param args - args
     */
    public static void main(String[] args) {
        new StartUi().start();
    }

    /**
     * Запускает цикл постоянного ввода.
     */
    private void start() {
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
        switch (new ConsoleInput().ask(String.join("", this.menuUi))) {
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
        String inputData = new ConsoleInput().ask("Enter name and description");
        String[] nameAndDesc = inputData.split(" ");
        if (nameAndDesc.length != 2) {
            System.out.println("Error: the entered data does not correspond to the format");
        } else {
            tracker.add(new Item(nameAndDesc[0], nameAndDesc[1], System.currentTimeMillis()));
            System.out.println("Item successfully added");
        }
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
        String inputData = new ConsoleInput().ask("Enter name, description and id of the item being updated: ");
        String[] nameDescAndId = inputData.split(" ");
        if (nameDescAndId.length != 3) {
            System.out.println("Error: the entered data does not correspond to the format");
        } else {
            Item newItem = new Item(nameDescAndId[0], nameDescAndId[1], System.currentTimeMillis());
            newItem.setId(nameDescAndId[2]);
            tracker.update(newItem);
            System.out.println("Item successfully updated");
        }
    }

    /**
     * deleteItem.
     */
    private void deleteItem() {
        String inputData = new ConsoleInput().ask("Enter id item's to be deleted: ");
        String[] id = inputData.split(" ");
        if (id.length != 1) {
            System.out.println("Error: the entered data does not correspond to the format");
        } else {
            Item tempItem = new Item("temp", "tempDesc", 123L);
            tempItem.setId(id[0]);
            tracker.delete(tempItem);
            System.out.println("Item successfully deleted");
        }
    }
    /**
     * findItemById.
     */
    private void findItemById() {
        String inputData = new ConsoleInput().ask("Enter item id to be find: ");
        String[] id = inputData.split(" ");
        if (id.length != 1) {
            System.out.println("Error: the entered data does not correspond to the format");
        } else {
            Item findItem = tracker.findById(id[0]);
            if (findItem != null) {
                System.out.println(findItem.toString());
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * findItemsByName.
     */
    private void findItemsByName() {
        String inputData = new ConsoleInput().ask("Enter item name to be find: ");
        String[] name = inputData.split(" ");
        if (name.length != 1) {
            System.out.println("Error: the entered data does not correspond to the format");
        } else {
            Item[] findItems = tracker.findByName(name[0]);
            if (findItems.length != 0) {
                for (Item findItem : findItems) {
                    System.out.println(findItem.toString());
                }
            } else {
                System.out.println("Item not found");
            }
        }
    }
}
