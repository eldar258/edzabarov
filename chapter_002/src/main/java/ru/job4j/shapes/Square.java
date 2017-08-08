package ru.job4j.shapes;

/**
 * Class Square.
 *
 * @author edzabarov
 * @since 08.08.2017
 */
public class Square implements Shape {
    /**
     * draw square.
     * @return - string
     */
    public String pic() {
        StringBuilder bf = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                bf.append("*");
            }
            bf.append(System.lineSeparator());
        }
        return bf.toString();
    }
}
