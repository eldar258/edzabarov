package ru.job4j.benchmark2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.benchmark2.
 *
 * @author edzabarov
 * @since 18.02.2018
 */
public class InnerDataTest {
    InnerData innerData = new InnerData();

    @Test
    public void whenLetterInWordAreSameThenTrue() {
        String string1 = "MAMA";
        String string2 = "AMAM";
        boolean expected = innerData.cheсkData(string1, string2);
        boolean result = true;
        assertThat(expected, is(result));
    }

    @Test
    public void whenLetterInWordAreSameThenTrue2() {
        String string1 = "NOSNOSNOSNOS123321123321";
        String string2 = "SONSONSONNOS321321321321";
        boolean expected = innerData.cheсkData(string1, string2);
        boolean result = true;
        assertThat(expected, is(result));
    }

    @Test
    public void whenLetterInWordAreNotSameThenTrue() {
        String string1 = "circle";
        String string2 = "square";
        boolean expected = innerData.cheсkData(string1, string2);
        boolean result = false;
        assertThat(expected, is(result));
    }

    @Test
    public void whenLetterInWordAreNotSameThenTrue2() {
        String string1 = "job4j";
        String string2 = "javarash";
        boolean expected = innerData.cheсkData(string1, string2);
        boolean result = false;
        assertThat(expected, is(result));
    }
}