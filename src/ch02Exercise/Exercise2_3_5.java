package ch02Exercise;

import ch02.LinkList2;


/**
 * 5. 编写一个单链表类的成员函数，实现删除不带头结点的单链表中数据域值等于x的第一个结点的操作。若删除成功，则返回被删除结点的位置；否则，返回-1。
 * 
 * @author zou
 * 
 * @see ch02.LinkList2#remove(Object) 方法实现删除不带结点的单链表中数据域值等于x的第一个结点的操作
 * 
 */
public class Exercise2_3_5 {

	public static void main(String[] args) throws Exception {
		LinkList2 L = new LinkList2();
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);
		L.insert(9, 0);
		System.out.println("删除前单链表中的各个数据元素为：");
		L.display();
		System.out.println("单链表中第一个数据元素的值为\"3\"的位置为："
				+ L.remove(new Integer(0)));
		System.out.println("删除数据元素\"3\"之后单链表中的各个数据元素为：");
		L.display();

	}
}

// 调试结果：
// 删除前单链表中的各个数据元素为：
// 0 1 2 3 4 5 6 7 8 0
// 单链表中第一个数据元素的值为"3"的位置为：3
// 删除数据元素"3"之后单链表中的各个数据元素为：
// 1 2 4 5 6 7 8 3
