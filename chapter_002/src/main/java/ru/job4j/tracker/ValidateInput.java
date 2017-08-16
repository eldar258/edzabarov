package ru.job4j.tracker;

/**
 * Class ru.job4j.tracker.
 *
 * @author edzabarov
 * @since 15.08.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * .
     * @param question -
     * @param range -
     * @return key.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean exit = true;
        int key = 0;
        do {
            exit = false;
            try {
                key = super.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println("ERROR: command not found.");
                exit = true;
            } catch (NumberFormatException nfe) {
                System.out.println("ERROR: command not found.");
                exit = true;
            }
        } while (exit);
        return key;
    }
}
