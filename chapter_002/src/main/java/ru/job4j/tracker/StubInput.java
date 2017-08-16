package ru.job4j.tracker;

/**
 * Класс, для теста StartUI.
 *
 * @author edzabarov
 * @since 07.08.2017
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
     * @param question - вопрос
     * @return ответ.
     */
    public String ask(String question) {
        return questions[position++];
    }
    /**
     * .
     * @param question -
     * @param ranges -
     * @return .
     * @throws MenuOutException -
     * @throws NumberFormatException -
     */
    public int ask(String question, int[] ranges) throws MenuOutException, NumberFormatException {
        return Integer.parseInt(questions[position++]);
    }
}
