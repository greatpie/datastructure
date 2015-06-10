package ch02;

/**
 * 
 * 带头结点的单链表及其基本操作
 * 
 */
import java.util.Scanner;

public class LinkList implements IList {
	private Node head;// 单链表的头指针

	// 单链表的构造函数
	public LinkList() {
		head = new Node(); // 初始化头结点
	}

	public LinkList(int n, boolean Order) throws Exception {
		this();// 初始化头结点
		if (Order) // 用尾插法顺序建立单链表
			create1(n);
		else
			// 用头插法逆位序建立单链表
			create2(n);
	}

	// 用尾插法顺序建立单链表。其中n为该单链表的元素个数
	public void create1(int n) throws Exception {
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		for (int j = 0; j < n; j++)
			// 输入n个元素的值
			insert(length(), sc.next());// 生成新结点,插入到表尾
	}

	// 用头插法逆位序建立单链表。其中n为该单链表的元素个数
	public void create2(int n) throws Exception {
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		for (int j = 0; j < n; j++)
			// 输入n个元素的值
			insert(0, sc.next());// 生成新结点,插入到表头
	}

	// 将一个已经存在的带头结点单链表置成空表
	public void clear() {
		head.setData(null);
		head.setNext(null);
	}

	// 判断当前带头结点的单链表是否为空
	public boolean isEmpty() {
		return head.getNext() == null;// 判断首结点是否为空
	}

	// 求带头结点单链表中的数据元素个数并由函数返回其值
	public int length() {
		Node p = head.getNext();// 初始化,p指向首结点,length为计数器
		int length = 0;
		while (p != null) {// 从首结点向后查找，直到p为空
			p = p.getNext();// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 读取带头结点单链表中的第i个数据元素
	public Object get(int i) throws Exception {
		Node p = head.getNext();// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (p != null && j < i) {// 从首结点向后查找，直到p指向第i个元素或p为空
			p = p.getNext();// 指向后继结点
			++j;// 计数器的值增1
		}
		if (j > i || p == null) { // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在");// 输出异常
		}
		return p.getData();// 返回元素p
	}

	// 在带头结点单链表中第i个数据元素之前插入一个值为x的数据元素
	public void insert(int i, Object x) throws Exception {
		Node p = head;// 初始化p为头结点,j为计数器
		int j = -1; // 第i个结点前驱的位置
		while (p != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.getNext();
			++j;// 计数器的值增1
		}
		if (j > i - 1 || p == null) // i不合法
			throw new Exception("插入位置不合理");// 输出异常

		Node s = new Node(x); // 生成新结点
		s.setNext(p.getNext());// 插入单链表中
		p.setNext(s);
	}

	// 将线性表中第i个数据元素删除。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		Node p = head;// p指向要删除结点的前驱结点
		int j = -1;
		while (p.getNext() != null && j < i - 1) {// 寻找i个结点的前驱
			p = p.getNext();
			++j;// 计数器的值增1
		}
		if (j > i - 1 || p.getNext() == null) { // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常
		}
		p.setNext(p.getNext().getNext());// 删除结点
	}

	// 在带头结点的单链表中查找值为x的元素，如果找到，则函数返回该元素在线性表中的位置，否则返回-1
	public int indexOf(Object x) {
		Node p = head.getNext();// 初始化,p指向首结点,j为计数器
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
		Node node = head.getNext();// 取出带头结点的单链表中的首结点元素
		while (node != null) {
			System.out.print(node.getData() + " ");// 输出数据元素的值
			node = node.getNext();// 取下一个结点
		}
		System.out.println();// 换行
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// 在非递减的有序单链表中插入一个值为x的数据元素，并使单链表仍保持有序的操作
	//方法一
    public void insert(int  x) {
		Node p = head.getNext();
		Node q = head;// q用来记录p的前驱结点
		int temp;
		while (p != null) {
			temp = ((Integer) p.getData()).intValue();
			if (temp < x) {
				q = p;
				p = p.getNext();
			} else
				break;
		}

		Node s = new Node(x); // 生成新结点
		s.setNext(p);// 将s结点插入到单链表的q结点与p结点之间
		q.setNext(s);
	}
    // 在非递减的有序单链表中插入一个值为x的数据元素，并使单链表仍保持有序的操作
	//方法二
    public void insert1(int  x) {
		Node p = head.getNext();

		while (p.getNext() != null&&((Integer) p.getNext().getData()).intValue()<x) {
            p = p.getNext();
		}
		Node s = new Node(x); // 生成新结点
		s.setNext(p.getNext());// 将s结点插入到单链表的q结点与p结点之间
		p.setNext(s);
	}

    // 实现对单链表就地逆置(采用的是头插法)
	public void reverse() {
		Node p = head.getNext();
		head.setNext(null);
		Node q;
		while (p != null) {
			q = p.getNext();
			p.setNext(head.getNext());
			head.setNext(p);
			p = q;
		}
	}

	// 实现删除单链表中数据域值等于x的所有结点的操作，并返回被删除结点的个数
	public int removeAll(Object x) {
		Node p = head.getNext();// 初始化,p指向首结点,j为计数器
		Node q = head; // 用来记录p的前驱结点
		int j = 0;// 用来记录被删除结点的个数
		while (p != null) { // 从单链表中的首结点开始对整个链表遍历一次
			if (p.getData().equals(x)) {
				q.setNext(p.getNext());
				++j;// 计数器的值增1
			} else
				q = p;
			p = p.getNext();// 指向下一个元素
		}
		return j;// 返回被删除结点的个数
	}
}
