package ru.job4j.benchmark;

/**
 * Class ru.ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 27.08.2017
 */
public class StubInput implements Input {
    /**
     * вопросы.
     */
    private String[] questions;
    /**
     * position.
     */
    private int position = 0;

    /**
     * конструктор.
     * @param questions - ред команд.
     */
    public StubInput(String[] questions) {
        this.questions = questions;
    }
    /**
     * тест.
     * @return ответ.
     */
    public String input() {
        return questions[position++];
    }
}
