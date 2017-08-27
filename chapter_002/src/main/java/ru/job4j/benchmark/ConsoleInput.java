package ru.job4j.benchmark;

import java.util.Scanner;

/**
 * Class Input from the console.
 *
 * @author edzabarov
 * @since 26.08.2017
 */
public class ConsoleInput implements Input {
    /**
     * input data.
     * @return -
     */
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
