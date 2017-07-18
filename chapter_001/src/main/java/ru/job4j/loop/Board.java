package ru.job4j.loop;

/**
*Class Board.
*@author edzabarov
*@since 9.07.2017
*/
public class Board {
	/**
	* paint.
	*@param width - width
	*@param height - height
	*@return sb;
	*/
	public String paint(int width, int height) {
		StringBuilder sb = new StringBuilder();
		final String line = System.getProperty("line.separator");
		int step = 1;
		for (int i = 1; i <= height; i++) {
			if (i % 2 == 1) {
				step = 1;
			} else {
				step = 0;
			}
			for (int j = 1; j <= width; j++) {
				if (j % 2 == step) {
					sb.append('x');
				} else {
					sb.append(' ');
				}
			}
			sb.append(line);
		}
		return sb.toString();
	}
}