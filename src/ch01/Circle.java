/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch01;



/**
 *
 * @author lxj
 */
class Circle implements Comparable,Shape{
    double d;
    public Circle(double d) {
       this.d=d;
    }


    public double area() {
        return 3.14*d*d;
    }

    public int compareTo(Object o) {
        if (this.area()>((Shape)o).area())
            return 1;
        else if (this.area()==((Shape)o).area())
               return 0;
        else return -1;
    }
   public String toString(){
       return "circle";
   }
}
