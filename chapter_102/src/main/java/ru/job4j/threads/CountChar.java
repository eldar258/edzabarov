package ru.job4j.threads;

/**
 * Class ru.job4j.threads.
 *
 * @author edzabarov
 * @since 21.02.2018
 */
public class CountChar implements Runnable {
    private String text;

    public CountChar(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        int result = 0;
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < 10000) {
            result = 0;
            for (int i = 0; i < text.length(); i++) {
                result++;
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Not final result " + result);
                    return;
                }
            }
        }
        System.out.println("Final result " + result);
    }
}
