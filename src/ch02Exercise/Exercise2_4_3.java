package ch02Exercise;

import ch02.Node;

/**
 * 3. 设计一个不带头结点的单链表类，要求：
 * (1)编写不带头结点的单链表类中的成员函数，包括：求线性表的长度、插入、删除和取结点值的操作函数。
 * (2)设计一个测试主函数，使其实际运行来验证类中各成员函数的正确性。
 * 
 * @author zou
 * 
 * @see ch02.LinkList2
 * @see ch02.DebugLinkList2
 * 实现了题目中的要求
 * 
 */
//不带头结点的单链表类

class LinkList2  {

	private Node head;// 单链表的首结点指针

	// 构造函数
	public LinkList2() {
		head = null;
	}

	// 将一个已经存在的单链表置成空表
	public void clear() {
		head = null;
	}

	// 判断当前单链表是否为空
	public boolean isEmpty() {
		return  head ==null;
	}

	// 求单链表中的数据元素个数并由函数返回其值
	public int length() {
		Node p = head;// 初始化,p指向首结点,length为计数器
		int length = 0;
		while (p != null) {// 从首结点向后查找，直到p为空
			p = p.getNext();// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 读取单链表中的第i个数据元素
	public Object get(int i) throws Exception {
		Node p = head;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (p != null && j < i) {// 从首结点向后查找，直到p指向第i个元素或p为空
			p = p.getNext();// 指向后继结点
			++j;// 计数器的值增1
		}
		if (j > i || p == null) // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 输出异常

		return p.getData();// 返回元素p
	}

	// 在单链表中第i个数据元素之前插入一个值为x的数据元素
	public void insert(int i, Object x) throws Exception {
		Node s = new Node(x);
		if (i == 0) { // 插入位置为表头
			s.setNext(head);
			head = s;
			return;
		}

		Node p = head;
		int j = 0;// 第i个结点前驱的位置
		while (p != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.getNext();
			++j;
		}
		if (j > i - 1 || p == null)
			throw new Exception("插入位置不合理");

		// 插入位置为表的中间或表尾
		s.setNext(p.getNext());
		p.setNext(s);
	}

	// 将线性表中第i个数据元素删除。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		Node p = head;// 初始化p为首结点,j为计数器
		Node q = null; // 用来记录p的前驱结点
		int j = 0;
		while (p != null && j < i) {// 寻找i个结点
			q = p;
			p = p.getNext();
			++j;// 计数器的值增1
		}
		if (j > i || p == null) // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常

		if (q == null)
			head = null;// 删除首结点
		else
			q.setNext(p.getNext());// 删除其他结点
	}

	// 在带头结点的单链表中查找值为x的元素，如果找到，则函数返回该元素在线性表中的位置，否则返回-1
	public int indexOf(Object x) {
		Node p = head;// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (p != null && !p.getData().equals(x)) {// 从单链表中的首结点元素开始查找，直到p.getData()指向元素x或到达单链表的表尾
			p = p.getNext();// 指向下一个元素
			++j;// 计数器的值增1
		}
		if (p != null)// 如果p指向表中的某一元素
			return j;// 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}

	// 输出线性表中的数据元素
	public void display() {
		Node node = head;// 取出带头结点的单链表中的首结点元素
		while (node != null) {
			System.out.print(node.getData() + " ");// 输出数据元素的值
			node = node.getNext();// 取下一个结点
		}
		System.out.println();// 换行
	}

}
//测试类
public class Exercise2_4_3 {
  public static void main(String[] args) throws Exception {
		// --------初始化单链表中各个元素--------
		LinkList2 L = new LinkList2();
		for (int i = 0; i <= 8; i++)
			L.insert(i, i);
		System.out.println("单链表中各个数据元素：");
		L.display(); // 输出单链表中所有的数据元素

		// --------调用length()求顺序表的长度--------
		System.out.println("单链表的长度:" + L.length());// 输出顺序表的长度

		// --------调用get(int i)取出第i个元素--------
		if (L.get(2) != null)// 取第二个元素
			System.out.println("单链表中第2个元素:" + L.get(2));

		// --------调用indexOf(Object x)查找x元素所在的位置--------
		int order = L.indexOf("c");// 求出数据元素字符串c在顺序表中的位置
		if (order != -1)
			System.out.println("单链表中值为字符串c的数据元素的位置为：" + order);// 输出数据元素c的位置
		else
			System.out.println("字符'c'不在此单链表中");

		// --------调用remove(int i)删除数据元素--------
		L.remove(2); // 删除第二个数据元素
		System.out.println("删除第二个数据元素后单链表中各个数据元素：");
		L.display();

		// --------调用 insert(int i, Object x)插入数据元素--------
		L.insert(2, 'd');// 在单链表的第三个位置插入数据元素d
		System.out.println("在2的位置插入数据元素d后单链表中各个数据元素：");
		L.display(); // 输出单链表中所有的数据元素

		// --------调用L.clear()将顺序表置空--------
		L.clear();
		System.out.println("将单链表置空后，再次打印表中的元素:");

		// --------调用isEmpty()判断顺序表是否为空--------
		if (L.isEmpty())
			System.out.println("单链表为空");
		else {
			System.out.println("单链表不为空,单链表中各个数据元素：");
			L.display();
		}
	}

}

// 调试结果：
// 单链表中各个数据元素：
// 0 1 2 3 4 5 6 7 8
// 单链表的长度:9
// 单链表中第2个元素:2
// 字符'c'不在此单链表中
// 删除第二个数据元素后单链表中各个数据元素：
// 0 1 3 4 5 6 7 8
// 在2的位置插入数据元素d后单链表中各个数据元素：
// 0 1 d 3 4 5 6 7 8
// 将单链表置空后，再次打印表中的元素:
// 单链表为空

