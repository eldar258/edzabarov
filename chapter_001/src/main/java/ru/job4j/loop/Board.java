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
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; i++) {
				if (j % 2 == 1) {
					sb.append('x');
				} else {
					sb.append(' ');
				}
			}
			sb.append(line);
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}