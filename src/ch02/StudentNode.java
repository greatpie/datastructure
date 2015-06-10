package ch02;

import java.util.Scanner;

/**
 * 
 * 学生成绩查询系统的结点,作为顺序表的数据元素(listElem[i])
 * 
 */
public class StudentNode {
	private int number; // 学号

	private String name; // 姓名

	private String sex; // 性别

	private double english; // 大学英语成绩

	private double math; // 高等数学成绩

	public StudentNode() { // 无参数时的构造函数
		this(0, null, null, 0.0, 0.0);
	}

	public StudentNode(int number, String name, String sex, double english,
			double math) { // 有参数时的构造函数
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.english = english;
		this.math = math;
	}

	public StudentNode(Scanner sc) {
		this(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc
				.nextDouble());
	}

	public double getEnglish() {
		return english;
	}

	public double getMath() {
		return math;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getSex() {
		return sex;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
