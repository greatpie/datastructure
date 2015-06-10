package ch02Exercise;

import ch02.LinkList;

/**
 * 4.编写一个单链表类的成员函数，实现对带头结点的单链表就地逆置的操作。所谓逆置，就是把（a1,a2,…,an）变成（an,an-1,…,a1）；所谓就地，就是指逆置后的结点仍存储在原来单链表的存储空间中，只不过通过修改链来改变单链表中每一个结点之间的逻辑位置关系。
 * 
 * @author zou
 * 
 * @see ch02.LinkList#reverse() 方法实现对单链表就地逆置
 * 
 */
public class Exercise2_3_4 {

	public static void main(String[] args) throws Exception {
		LinkList L = new LinkList();
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);
		System.out.println("逆置前单链表中的各个数据元素为：");
		L.display();
		L.reverse();
		System.out.println("逆置后单链表中的各个数据元素为：");
		L.display();

	}

}

// 调试结果：
// 逆置前单链表中的各个数据元素为：
// 0 1 2 3 4 5 6 7 8
// 逆置后单链表中的各个数据元素为：
// 8 7 6 5 4 3 2 1 0
