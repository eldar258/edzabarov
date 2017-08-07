package ru.job4j.tracker;

/**
 * Class Интерфейс ввода данных.
 *
 * @author edzabarov
 * @since 07.08.2017
 */

public interface Input {
    /**
     * .
     * @param question - вопрос
     * @return ответ.
     */
    String ask(String question);
}
