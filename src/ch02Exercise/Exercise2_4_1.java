package ch02Exercise;

/**
 * 1.在顺序表类中增加一个主函数，使其实际运行来测试顺序表中各成员函数的正确性。
 * 
 * @author zou
 * 
 * @see ch02.DebugSqList 中实现了题目中的要求
 * 
 */
//顺序表类
class SqList  {
	private Object[] listElem; // 线性表存储空间

	private int curLen; // 当前长度

	// 顺序表的构造函数，构造一个存储空间容量为maxSize的线性表
	public SqList(int maxSize) {
		curLen = 0; // 置顺序表的当前长度为0
		listElem = new Object[maxSize];// 为顺序表分配maxSize个存储单元
	}

	// 将一个已经存在的线性表置成空表
	public void clear() {
		curLen = 0; // 置顺序表的当前长度为0

	}

	// 判断当前线性表中数据元素个数是否为0,若为0则函数返回true，否则返回false
	public boolean isEmpty() {
		return curLen == 0;
	}

	// 求线性表中的数据元素个数并由函数返回其值
	public int length() {
		return curLen; // 返回顺序表的当前长度
	}

	// 读取到线性表中的第i个数据元素并由函数返回其值。其中i取值范围为：0≤i≤length()-1,如果i值不在此范围则抛出异常
	public Object get(int i) throws Exception {
		if (i < 0 || i > curLen - 1) // i小于0或者大于表长减1
			throw new Exception("第" + i + "个元素不存在"); // 输出异常

		return listElem[i]; // 返回顺序表中第i个数据元素
	}

	// 在线性表的第i个数据元素之前插入一个值为x的数据元素。其中i取值范围为：0≤i≤length()。如果i值不在此范围则抛出异常,当i=0时表示在表头插入一个数据元素x,当i=length()时表示在表尾插入一个数据元素x
	public void insert(int i, Object x) throws Exception {
		if (curLen == listElem.length) // 判断顺序表是否已满
			throw new Exception("顺序表已满");// 输出异常

		if (i < 0 || i > curLen) // i小于0或者大于表长
			throw new Exception("插入位置不合理");// 输出异常

		for (int j = curLen; j > i; j--)
			listElem[j] = listElem[j - 1];// 插入位置及之后的元素后移

		listElem[i] = x; // 插入x
		curLen++;// 表长度增1
	}

	// 将线性表中第i个数据元素删除。其中i取值范围为：0≤i≤length()- 1,如果i值不在此范围则抛出异常
	public void remove(int i) throws Exception {
		if (i < 0 || i > curLen - 1) // i小于1或者大于表长减1
			throw new Exception("删除位置不合理");// 输出异常

		for (int j = i; j < curLen - 1; j++)
			listElem[j] = listElem[j + 1];// 被删除元素之后的元素左移

		curLen--; // 表长度减1
	}

	// 返回线性表中首次出现指定元素的索引，如果列表不包含此元素，则返回 -1
	public int indexOf(Object x) {
		int j = 0;// j为计数器
		while (j < curLen && !listElem[j].equals(x))
			// 从顺序表中的首结点开始查找，直到listElem[j]指向元素x或到达顺序表的表尾
			j++;
		if (j < curLen)// 判断j的位置是否位于表中
			return j; // 返回x元素在顺序表中的位置
		else
			return -1;// x元素不在顺序表中
	}

	// 输出线性表中的数据元素
	public void display() {
		for (int j = 0; j < curLen; j++)
			System.out.print(listElem[j] + " ");
		System.out.println();// 换行

	}
}
//测试类
 public class Exercise2_4_1 {
    public static void main(String[] args) throws Exception {
		// --------调用构造函数--------
		SqList L = new SqList(10); // 构造一个10个存储空间的顺序表

		// --------调用 insert(int i, Object x)插入数据元素--------
		for (int i = 0; i <= 8; i++) // 对该顺序表的前9个元素进行赋值，分别为0、1、2...8
			L.insert(i, i);

		// --------调用length()求顺序表的长度--------
		System.out.println("顺序表的长度:" + L.length());// 输出顺序表的长度

		// --------调用get(int i)取出第i个元素--------
		System.out.println("顺序表中各个数据元素:");// 输出
		L.display();

		// --------调用indexOf(Object x)查找x元素所在的位置--------
		int order = L.indexOf(8);// 求出数据元素8在顺序表中的位置
		if (order != -1)
			System.out.println("顺序表中值为8的数据元素的位置为：" + order);// 输出
		else
			System.out.println("8不在此单链表中");

		// --------调用remove(int i)删除数据元素表--------
		L.remove(5);// 删除数据元素5
		System.out.println("顺序表中删除数据元素5后，表的长度：" + L.length());// 输出
		System.out.println("顺序表中删除数据元素5后，剩余的数据元素：");// 输出
		L.display();

		// --------调用insert(int i, Object x)把数据元素x插入到i的位置--------
		L.insert(5, 5);
		System.out.println("顺序表中在5的位置前插入数据元素5后，表的长度：" + L.length());
		System.out.println("顺序表中在5的位置前插入数据元素5后，表中的数据元素：");
		L.display();

		// --------调用L.clear()将顺序表置空--------
		L.clear();
		System.out.println("将顺序表置空后，再次打印表中的元素：");
		L.display();

		// --------调用isEmpty()判断顺序表是否为空--------
		if (L.isEmpty())
			System.out.println("顺序表为空");
		else
			System.out.println("顺序表不为空");

	}
}

// 运行结果如下：
// 顺序表的长度:9
// 顺序表中各个数据元素:
// 0 1 2 3 4 5 6 7 8
// 顺序表中值为8的数据元素的位置为：8
// 顺序表中删除数据元素5后，表的长度：8
// 顺序表中删除数据元素5后，剩余的数据元素：
// 0 1 2 3 4 6 7 8
// 顺序表中在5的位置前插入数据元素5后，表的长度：9
// 顺序表中在5的位置前插入数据元素5后，表中的数据元素：
// 0 1 2 3 4 5 6 7 8
// 将顺序表置空后，再次打印表中的元素：
//
// 顺序表为空