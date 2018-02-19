package ru.job4j.threads;

/**
 * Class ru.job4j.threads.
 *
 * @author edzabarov
 * @since 19.02.2018
 */
public class CountSpacesInStringThread implements Runnable {
    private String string;

    public CountSpacesInStringThread(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                result++;
            }
        }
        System.out.println(String.format("The string contains %s spaces", result));
    }
}
