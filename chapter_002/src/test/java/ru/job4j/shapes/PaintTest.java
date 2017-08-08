package ru.job4j.shapes;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class Test class Paint.
 *
 * @author edzabarov
 * @since 08.08.2017
 */
public class PaintTest {
    /**
     * square test.
     */
    @Test
    public void whenDrawSquareThenDrawSquare() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new Paint().draw(new Square());
        StringBuilder result = new StringBuilder();
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        result.append("**********\r\n");
        ByteArrayOutputStream resultat = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultat));
        System.out.println(result);
        assertThat(baos.toString(), is(resultat.toString()));
    }

    /**
     * triangle test.
     */
    @Test
    public void whenDrawTriangleThenDrawTriangle() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        new Paint().draw(new Triangle());
        StringBuilder result = new StringBuilder();
        result.append("*\r\n");
        result.append("**\r\n");
        result.append("***\r\n");
        result.append("****\r\n");
        result.append("*****\r\n");
        result.append("******\r\n");
        result.append("*******\r\n");
        result.append("********\r\n");
        result.append("*********\r\n");
        result.append("**********\r\n");
        ByteArrayOutputStream resultat = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultat));
        System.out.println(result);
        assertThat(baos.toString(), is(resultat.toString()));
    }
}
