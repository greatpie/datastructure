package ch02;


/**
 * 
 * 带头结点的循环链表及其基本操作
 * 
 */
public class CircleLinkList implements IList {
	private Node head;// 循环单链表的头指针

	// 循环单链表的构造函数
	public CircleLinkList() {
		head = new Node(); // 初始化头结点
		head.setNext(head);
	}

	// 将一个已经存在的带头结点的循环单链表置成空表
	public void clear() {
		head.setNext(head);
	}

	// 判断当前带头结点的循环单链表是否为空
	public boolean isEmpty() {
		return head.getNext().equals(head);
	}

	// 求带头结点的循环单链表中的数据元素个数并由函数返回其值
	public int length() {
		Node p = head.getNext();// 初始化,p指向首结点,length为计数器
		int length = 0;
		while (!p.equals(head)) {// 从首结点向后查找，直到p指向头结点
			p = p.getNext();// 指向后继结点
			++length;// 长度增1
		}
		return length;
	}

	// 读取带头结点的循环单链表中的第i个数据元素
	public Object get(int i) throws Exception {
		Node p = head.getNext();// 初始化,p指向首结点,j为计数器
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

	// 在带头结点的循环单链表中第i个数据元素之前插入一个值为x的数据元素
	public void insert(int i, Object x) throws Exception {
		Node p = head;// 初始化p为头结点,j为计数器
		int j = -1; // 第i个结点前驱的位置
		while ((!p.equals(head) || j == -1) && j < i - 1) {// 寻找i个结点的前驱
			p = p.getNext();
			++j;// 计数器的值增1
		}
		if (j > i - 1 || (p.equals(head) && j != -1)) // i不合法
			throw new Exception("插入位置不合理");// 输出异常

		Node s = new Node(x); // 生成新结点
		s.setNext(p.getNext());// 插入单链表中
		p.setNext(s);
	}

	// 将循环单链表中第i个数据元素删除。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		Node p = head;// p指向要删除结点的前驱结点
		int j = -1;
		while ((!p.getNext().equals(head) || j == -1) && j < i - 1) {// 寻找i个结点的前驱
			p = p.getNext();
			++j;// 计数器的值增1
		}
		if (j > i - 1 || p.getNext().equals(head)) { // i小于0或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常
		}
		p.setNext(p.getNext().getNext());// 删除结点
	}

	// 在带头结点的循环单链表中查找值为x的元素，如果找到，则函数返回该元素在线性表中的位置，否则返回-1
	public int indexOf(Object x) {
		Node p = head.getNext();// 初始化,p指向首结点,j为计数器
		int j = 0;
		while (!p.equals(head) && !p.getData().equals(x)) {// 从单链表中的首结点元素开始查找，直到p.getData()指向元素x或到达单链表的表尾
			p = p.getNext();// 指向下一个元素
			++j;// 计数器的值增1
		}
		if (!p.equals(head))// 如果p指向表中的某一元素
			return j;// 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}

	// 输出循环链表中的数据元素
	public void display() {
		Node node = head.getNext();// 取出带头结点的单链表中的首结点元素
		while (!node.equals(head)) {
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

}
