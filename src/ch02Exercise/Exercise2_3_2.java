package ch02Exercise;

import ch02.SqList;

/**
 * 2.编写一个顺序表类的成员函数，实现对顺序表循环右移k位的操作。即原来顺序表为（a1,a2,…,an-k,an-k+1,…,an），循环向右移动k位后变成（an-k+1,…,an,a1,a2,…,an-k）。要求时间复杂度为O（n）。
 * 
 * @author zou
 * 
 * @see ch02.SqList#shit(int) 实现对顺序表右移k位
 * 
 */
public class Exercise2_3_2 {

	public static void main(String[] args) throws Exception {
		SqList L = new SqList(10);
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);
		System.out.println("右移前顺序表中的各个数据元素为：");
		L.display();
		L.shit(3);
		System.out.println("右移3位后顺序表中的各个数据元素为：");
		L.display();
	}
}

// 调试结果：
// 右移前顺序表中的各个数据元素为：
// 0 1 2 3 4 5 6 7 8
// 右移3位后顺序表中的各个数据元素为：
// 6 7 8 0 1 2 3 4 5
