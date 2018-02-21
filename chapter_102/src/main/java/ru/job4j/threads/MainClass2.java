package ru.job4j.threads;

/**
 * Class ru.job4j.threads.
 *
 * @author edzabarov
 * @since 21.02.2018
 */
public class MainClass2 {
    public static void main(String[] args) {
        Time time = new Time(System.currentTimeMillis(), 1);
        Thread timeThread = new Thread(time);
        timeThread.start();
        String text = "Simple text";
        Thread countCharTread = new Thread(new CountChar(text));
        time.addThread(countCharTread);
        countCharTread.start();
    }
}
