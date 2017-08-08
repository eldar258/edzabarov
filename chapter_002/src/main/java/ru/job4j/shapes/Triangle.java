package ru.job4j.shapes;

/**
 * Class Triangle.
 *
 * @author edzabarov
 * @since 08.08.2017
 */
public class Triangle implements Shape {
    /**
     * draw Triangle.
     * @return - string.
     */
    public String pic() {
        StringBuilder bf = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                bf.append("*");
            }
            bf.append(System.lineSeparator());
        }
        String result = bf.toString();
        return result;
    }
}
