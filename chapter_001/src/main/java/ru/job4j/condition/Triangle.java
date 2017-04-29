package ru.job4j.condition;

/**
*Class Triangle.
*@author edzabarov
*@since 29.04.2007
*/
public class Triangle {
	/**
	* a.
	*/
	private Point a;
	/**
	* a.
	*/
	private Point b;
	/**
	* a.
	*/
	private Point c;
	/**
	* Triangle.
	*@param a - a
	*@param b - b
	*@param c - c
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
  * area.
  *@return x
  */
	public double area() {
		return Math.abs((b.getX() * c.getY() + c.getX() * a.getY()
								+ a.getX() * b.getY()  - b.getX() * a.getY() - a.getX()
									* c.getY() - c.getX() * b.getY()) / 2.0);
	}
}