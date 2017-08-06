package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class Ввод данных с консоли.
 *
 * @author edzabarov
 * @since 06.08.2017
 */
public class ConsoleInput {
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
}
