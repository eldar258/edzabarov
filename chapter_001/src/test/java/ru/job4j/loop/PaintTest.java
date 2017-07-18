package ru.job4j.loop;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author edzabarov
* @version $Id$
* @since 13.07.2017
*/
public class PaintTest {
	/**
	*Test piramid.
	*/
    @Test
   public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^%s", System.getProperty("line.separator"), System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
	/**
	*Test piramid.
	*/
    @Test
    public void whenPiramidWithHeightFiveThenStringWithFiveRows() {
		Paint paint = new Paint();
        String result = paint.piramid(5);
        String expected = String.format("    ^    %s   ^^^   %s  ^^^^^  %s ^^^^^^^ %s^^^^^^^^^%s", System.getProperty("line.separator"), System.getProperty("line.separator"), System.getProperty("line.separator"), System.getProperty("line.separator"), System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
}