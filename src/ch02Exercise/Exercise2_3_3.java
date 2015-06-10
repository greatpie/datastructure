package ch02Exercise;

import ch02.LinkList;

/**
 * 3.编写一个单链表类的成员函数，实现在非递减的有序单链表中插入一个值为x的数据元素，并使单链表仍保持有序的操作。
 * 
 * @author zou
 * 
 * @see ch02.LinkList#insert(int) 方法实现在非递减的有序单链表中插入一个值为x的数据元素，并使单链表仍保持有序的操作
 * 
 */
public class Exercise2_3_3 {

	public static void main(String[] args) throws Exception {
		LinkList L = new LinkList();
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);
		System.out.println("插入前单链表中的各个数据元素为：");
		L.display();
		L.insert(4);   //也可用 L.insert1(4);
		System.out.println("插入后单链表中的各个数据元素为：");
		L.display();

	}
}

// 调试结果：
// 插入前单链表中的各个数据元素为：
// 0 1 2 3 4 5 6 7 8
// 插入后单链表中的各个数据元素为：
// 0 1 2 3 4 4 5 6 7 8
