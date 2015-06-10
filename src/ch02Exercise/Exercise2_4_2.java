package ch02Exercise;


/**
 * 2.在单链表类中增加一个主函数，使其实际运行来测试单链表中各成员函数的正确性。
 * 
 * @author zou
 * 
 * @see ch02.DebugLinkList 中实现了题目中的要求
 * 
 */
import ch02.Node;
import java.util.Scanner;
//单链表类
class LinkList  {
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

	
}
//测试类
public class Exercise2_4_2 {
public static void main(String[] args) throws Exception {
		// --------调用create(int n)从表尾到表头逆向建立单链表--------
		System.out.println("请输入3个单链表中的数据元素：");
		LinkList L = new LinkList(3, true);// 从表头到表尾顺序建立一个表长为3的单链表
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
// 运行结果如下：
// 请输入3个单链表中的数据元素：
// 1 2 3
// 单链表中各个数据元素：
// 1 2 3
// 单链表的长度:3
// 单链表中第2个元素:3
// 字符'c'不在此单链表中
// 删除第二个数据元素后单链表中各个数据元素：
// 1 2
// 在2的位置入数据元素d后单链表中各个数据元素：
// 1 2 d
// 将单链表置空后，再次打印表中的元素:
// 单链表为空