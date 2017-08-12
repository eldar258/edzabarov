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
     * tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * Конструктор основной.
     *
     * @param input   - input.
     * @param tracker - tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * main.
     *
     * @param args - args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).start();
    }

    /**
     * Запускает цикл постоянного ввода.
     */
    public void start() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillAction();
        do {
            menuTracker.show();
            try {
                int key = Integer.parseInt(this.input.ask("Select: "));
                menuTracker.select(key);
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: command not found.");
            }
        } while (!"y".equals(this.input.ask("Exit: <y>")));
    }
}