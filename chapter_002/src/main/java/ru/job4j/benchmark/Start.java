package ru.job4j.benchmark;

/**
 * Class Main.
 *
 * @author edzabarov
 * @since 26.08.2017
 */
public class Start {
    /**
     * main.
     * @param args .
     */
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.setEntranceBanknote(Integer.parseInt(new ConsoleInput().input()));
        System.out.println(machine.variantsChange());
    }
}
