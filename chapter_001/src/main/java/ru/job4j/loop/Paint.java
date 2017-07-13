package ru.job4j.loop;

/**
*Class Paint.
*@author edzabarov
*@since 13.07.2017
*/
public class Paint {
	/**
	* piramid.
	*@param height - height
	*@return sb;
	*/
	public String piramid(int height) {
		StringBuilder sb = new StringBuilder();
		final String line = System.getProperty("line.separator");
		int width = height * 2 - 1;
		for (int i = 1; i <= height; i++) {
			int step = (width - i * 2 + 1) / 2;
			for (int j = 1; j <= width; j++) {
				if (j <= step || j > (step + i * 2 - 1)) {
					sb.append(' ');
				} else {
					sb.append('^');
				}
			}
			if (i != height) {
				sb.append(line);
			}
		}
		return sb.toString();
	}
}