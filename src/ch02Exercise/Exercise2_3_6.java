package ch02Exercise;

import ch02.LinkList;

/**
 * 6.编写一个单链表类的成员函数，实现删除带头结点的单链表中数据域值等于x的所有结点的操作。要求函数返回被删除结点的个数。
 * 
 * @author zou
 * 
 * @see ch02.LinkList#remove(Object) 方法实现删除带头结点的单链表中数据域值等于x的所有结点的操作，并返回被删除结点的个数
 * 
 */
public class Exercise2_3_6 {

	public static void main(String[] args) throws Exception {
		LinkList L = new LinkList();// 注意：此时调用为不带头结点的构造函数
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);// 注意：此时调用为不带头结点的插入函数
		L.insert(9, 3);
		System.out.println("删除前单链表中的各个数据元素为：");
		L.display();
		System.out.println("数据元素为\"3\"的位置为：" + L.removeAll(new Integer(3)));
		System.out.println("删除数据元素\"3\"之后单链表中的各个数据元素为：");
		L.display();

	}
}

// 调试结果：
// 删除前单链表中的各个数据元素为：
// 0 1 2 3 4 5 6 7 8 3
// 数据元素为"3"的位置为：2
// 删除数据元素"3"之后单链表中的各个数据元素为：
// 0 1 2 4 5 6 7 8
