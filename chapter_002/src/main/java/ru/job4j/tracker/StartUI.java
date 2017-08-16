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
        new StartUI(new ValidateInput(), new Tracker()).start();
    }

    /**
     * Запускает цикл постоянного ввода.
     */
    public void start() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillAction();
        do {
            menuTracker.show();
            int key = this.input.ask("Select: ", menuTracker.getRanges());
            menuTracker.select(key);
        } while (!"y".equals(this.input.ask("Exit: <y>")));
    }
}