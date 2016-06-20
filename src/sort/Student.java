package sort;

import ch02.StudentNode;

/**
 * Created by pie on 2016-5-23.
 */
public class Student {
    protected String name;
    protected int grade;
    protected int rank;
    public Student(String name,int grade){
        this.name = name;
        this.grade =grade;
    }
    public Student(){
    }
    public void printInfo(){
        System.out.println(name+','+grade+','+rank+',');
    }
}
