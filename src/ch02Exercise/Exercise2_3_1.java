package ch02Exercise;

import ch02.SqList;

/**
 * 1.编写一个顺序表类的成员函数，实现对顺序表就地逆置的操作。所谓逆置，就是把（a1,a2,…,an）变成（an,an-1,…,a1）；所谓就地，就是指逆置后的数据元素仍存储在原来顺序表的存储空间中，即不为逆置后的顺序表另外分配存储空间。
 * 
 * @author zou
 * 
 * @see ch02.SqList#reverse()方法实现对顺序表就地逆置
 * 
 */
public class Exercise2_3_1 {

	public static void main(String[] args) throws Exception {
		SqList L = new SqList(10);
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);
		System.out.println("逆置前顺序表中的各个数据元素为：");
		L.display();
		L.reverse();
		System.out.println("逆置后顺序表中的各个数据元素为：");
		L.display();
	}
}

// 调试结果：
// 逆置前顺序表中的各个数据元素为：
// 0 1 2 3 4 5 6 7 8
// 逆置后顺序表中的各个数据元素为：
// 8 7 6 5 4 3 2 1 0
