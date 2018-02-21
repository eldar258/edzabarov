package ru.job4j.threads;

/**
 * Class ru.job4j.threads.
 *
 * @author edzabarov
 * @since 19.02.2018
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("start");
        String string = "I am studying java on job4j !! There are 16 words and 16 spaces in this line.";

        Thread countSpaceInStringThread =  new Thread(new CountSpacesInStringThread(string));
        countSpaceInStringThread.start();

        Thread countWordInStringThread = new Thread(new CountWordsInStringThread(string));
        countWordInStringThread.start();

        try {
            countSpaceInStringThread.join();
            countWordInStringThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
