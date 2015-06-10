/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch01;




/**
 *
 * @author lxj
 */
public class FindMaxExamp {
public static Comparable findMax(Comparable[] a){
	        int k=0;
	        for(int i=1;i<a.length;i++)
	           if (a[i].compareTo(a[k])>0)
	              k=i;
	        return a[k];
	    }
	   public static void main(String[] args){
	        Comparable[] sh1={new Circle(2.0),new Square(3.0),new Rectangle(3.0,4.0)};

	        String[] st1={ "Joe", "Bob", "Bill", "Zeke"};
	        System.out.println(findMax(sh1).toString());
	        System.out.println(findMax(st1));
	    }

}
