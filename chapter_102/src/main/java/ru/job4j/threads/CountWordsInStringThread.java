package ru.job4j.threads;

/**
 * Class ru.job4j.threads.
 *
 * @author edzabarov
 * @since 19.02.2018
 */
public class CountWordsInStringThread implements Runnable {
    private String string;

    public CountWordsInStringThread(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        int result = 0;
        boolean startWord = false;
        for (int i = 0; i < string.length(); i++) {
            boolean isLetter = Character.isJavaIdentifierPart(string.charAt(i));
            if (startWord) {
                if (!isLetter) {
                    startWord = false;
                }
            } else {
                if (isLetter) {
                    startWord = true;
                    result++;
                }
            }
        }
        System.out.println(String.format("The string contains %s words", result));
    }
}
