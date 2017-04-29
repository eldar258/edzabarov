package ru.job4j.condition;

/**
*Class Point.
*@author edzabarov
*@since 29.04.2007
*/
public class Point {
	/**
	* x.
	*/
   private int x;
   /**
	* y.
	*/
   private int y;
	/**
	* Point.
	*@param x - x
	*@param y - y
	*/
   public  Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
  /**
  * getX.
  *@return x
  */
  public int getX() {
      return this.x;
  }
	/**
	* getY.
	*@return y
	*/
  public int getY() {
     return this.y;
  }
  /**
  * is.
  *@param a - a
  *@param b - b
  *@return boolean
  */
  public boolean is(int a, int b) {
	  return this.y == a * this.x + b;
  }
}