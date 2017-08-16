package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class Ввод данных с консоли.
 *
 * @author edzabarov
 * @since 06.08.2017
 */
public class ConsoleInput implements Input {
    /**
     * scanner.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Считывает данные с консоли.
     * @param question - Вопрос пользователю
     * @return data
     */
    public String ask(String question) {
        System.out.println(question);
        return sc.nextLine();
    }
    /**
     *
     * @param question -
     * @param ranges -
     * @return .
     * @throws MenuOutException -
     * @throws NumberFormatException -
     */
    public int ask(String question, int[] ranges) throws MenuOutException, NumberFormatException {
        System.out.println(question);
        int result = Integer.parseInt(sc.nextLine());
        boolean notValidate = true;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == result) {
                notValidate = false;
                break;
            }
        }
        if (notValidate) {
            throw new MenuOutException("Error");
        }
        return result;
    }
}
