package ch02Exercise;

import java.util.Scanner;

/**
 * 4.设计一个带头结点的双向循环链表类，要求：
 *(1)编写带头结点的双向循环链表类中的成员函数，包括：求线性表的长度、插入、删除和取结点值的操作函数。
 *(2)设计一个测试主函数，使其实际运行来验证类中各成员函数的正确性。
 * 
 * @author zou
 * 
 * @see ch02.DuLinkList
 * @see ch02.DebugDuLinkList
 * 实现了题目中的要求
 * 
 */
//双向链表的结点类
class DuLNode {
	private Object data;// 存放结点值

	private DuLNode prior; // 前驱结点的引用

	private DuLNode next; // 后继结点的引用

	public DuLNode() {// 无参数时的构造函数
		this(null);
	}

	public DuLNode(Object data) {// 构造值为data的结点
		this.data = data;
		this.prior = null;
		this.next = null;
	}

	public Object getData() {
		return data;
	}

	public DuLNode getNext() {
		return next;
	}

	public DuLNode getPrior() {
		return prior;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setNext(DuLNode next) {
		this.next = next;
	}

	public void setPrior(DuLNode prior) {
		this.prior = prior;
	}
}

//双向链表类
class DuLinkList  {
	private DuLNode head;// 双向循环链表的头结点

	// 双向链表的构造函数
	public DuLinkList() {
		head = new DuLNode(); // 初始化头结点
		head.setPrior(head);// 初始化头结点的前驱和后继
		head.setNext(head);
	}

	// 从表尾到表头逆向建立双向链表的算法。其中n为该双向链表的元素个数
	public DuLinkList(int n) throws Exception {
		this();
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		for (int j = 0; j < n; j++)
			insert(0, sc.next());// 生成新结点,插入到表头
	}

	// 在双向循环链表的第i个数据元素之前插入一个值为x的数据元素，i等于表长时，p指向头结点；i大于表长时，p=NULL。
	// 其中i取值范围为：0≤i≤length()。当i=0时表示在表头插入一个数据元素x,当i=length()时表示在表尾插入一个数据元素x
	public void insert(int i, Object x) throws Exception {
		DuLNode p = head.getNext();// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (!p.equals(head) && j < i) {// 寻找插入位置i
			p = p.getNext();// 指向后继结点
			++j;// 计数器的值增1
		}

		if (j != i && !p.equals(head)) // i小于0或者大于表长
			throw new Exception("插入位置不合理");// 输出异常

		DuLNode s = new DuLNode(x);// 生成新结点
		p.getPrior().setNext(s);
		s.setPrior(p.getPrior());
		s.setNext(p);
		p.setPrior(s);
	}

	// 将双向循环链表中第i个数据元素删除。其中i 取值范围为：0≤i≤ength()-1
	public void remove(int i) throws Exception {
		DuLNode p = head.getNext();// 初始化,p指向首节点结点,j为计数器
		int j = 0;
		while (!p.equals(head) && j < i) {// 寻找删除位置i
			p = p.getNext();// 指向后继结点
			++j;// 计数器的值增1
		}

		if (j != i) // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常

		p.getPrior().setNext(p.getNext());
		p.getNext().setPrior(p.getPrior());
	}

	// 将一个已经存在的双向循环链表置成空表
	public void clear() {
		head.setPrior(head);
		head.setNext(head);
	}

	// 判断当前双向循环链表是否为空
	public boolean isEmpty() {
		return head.equals(head.getNext());
	}

	// 读取双向循环链表中的第i个数据元素
	public Object get(int i) throws Exception {
		DuLNode p = head.getNext();// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (!p.equals(head) && j < i) {// 从首结点向后查找，直到p指向第i个元素或p指向头结点
			p = p.getNext();// 指向后继结点
			++j;// 计数器的值增1
		}
		if (j > i || p.equals(head)) { // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 输出异常
		}
		return p.getData();// 返回元素p
	}

	// 求双向循环链表中的数据元素个数并由函数返回其值
	public int length() {
		DuLNode p = head.getNext();// 初始化,p指向首结点,length为计数器
		int length = 0;
		while (!p.equals(head)) {// 从首结点向后查找，直到p指向头结点
			p = p.getNext();// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 在双向循环链表中查找值为x的元素，如果找到，则函数返回该元素在线性表中的位置，否则返回-1
	public int indexOf(Object x) {
		DuLNode p = head.getNext();// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (!p.equals(head) && !p.getData().equals(x)) {// 从链表中的首结点元素开始查找，直到p.getData()指向元素x或到达链表的表尾
			p = p.getNext();// 指向下一个元素
			++j;// 计数器的值增1
		}
		if (!p.equals(head))// 如果p指向表中的某一元素
			return j;// 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}

	public void display() {
		DuLNode node = head.getNext();// 取出带头结点的双向链表中的首结点
		while (!node.equals(head)) {
			System.out.print(node.getData() + " ");// 输出数据元素的值
			node = node.getNext();
		}
		System.out.println();
	}

	public DuLNode getHead() {
		return head;
	}

	public void setHead(DuLNode head) {
		this.head = head;
	}

}

//测试类
public class Exercise2_4_4 {
    public static void main(String[] args) throws Exception {
		// --------调用构造函数--------
		System.out.println("请输入3个双向循环链表中的数据元素：");
		DuLinkList L = new DuLinkList(3);// 从表尾到表头逆向建立一个表长为3的单链表
		System.out.println("双向循环链表中各个数据元素：");
		L.display();

		// --------调用length()求顺序表的长度--------
		System.out.println("双向循环链表的长度:" + L.length());// 输出顺序表的长度

		// --------调用get(int i)取出第i个元素--------
		if (L.get(2) != null)// 取第二个元素
			System.out.println("双向循环链表中第2个元素:" + L.get(2));

		// --------调用indexOf(Object x)查找x元素所在的位置--------
		int order = L.indexOf("c");// 求出数据元素字符串c在顺序表中的位置
		if (order != -1)
			System.out.println("双向循环链表中值为字符串c的数据元素的位置为：" + order);// 输出数据元素c的位置
		else
			System.out.println("字符'c'不在此双向循环链表中");

		// --------调用remove(int i)删除数据元素--------
		L.remove(2); // 删除第二个数据元素
		System.out.println("删除第二个数据元素后双向循环链表中各个数据元素：");
		L.display();

		// --------调用 insert(int i, Object x)插入数据元素--------
		L.insert(2, 'd');// 在双向循环链表的第三个位置插入数据元素d
		System.out.println("在2的位置插入数据元素d后双向循环链表中各个数据元素：");
		L.display();

		// --------调用L.clear()将顺序表置空--------
		L.clear();
		System.out.println("将双向循环链表置空后，再次打印表中的元素:");

		// --------调用isEmpty()判断顺序表是否为空--------
		if (L.isEmpty())
			System.out.println("双向循环链表为空");
		else {
			System.out.println("双向循环链表不为空,双向循环链表中各个数据元素：");
			L.display();
		}
	}
}

// 调试结果：
// 请输入3个双向循环链表中的数据元素：
// 1 2 3
// 双向循环链表中各个数据元素：
// 3 2 1
// 双向循环链表的长度:3
// 双向循环链表中第2个元素:1
// 字符'c'不在此双向循环链表中
// 删除第二个数据元素后双向循环链表中各个数据元素：
// 3 2
// 在2的位置插入数据元素d后双向循环链表中各个数据元素：
// 3 2 d
// 将双向循环链表置空后，再次打印表中的元素:
// 双向循环链表为空
