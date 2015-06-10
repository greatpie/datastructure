/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch01;

/**
 *
 * @author lxj
 */
class Rectangle implements Comparable,Shape{
   double d;double d0;
    public Rectangle(double d, double d0) {
        this.d=d;
        this.d0=d0;
    }

    public double area() {
        return d*d0;
    }
  public int compareTo(Object o) {
        if (this.area()>((Shape)o).area())
            return 1;
        else if (this.area()==((Shape)o).area())
               return 0;
        else return -1;
    }
   public String toString(){
       return "Rectangle";
   }
}
