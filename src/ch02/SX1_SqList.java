package ch02;

/**
 *
 * 实验一 顺序表的基本操作
 *
 */
import java.util.Scanner;
public class SX1_SqList {
	private Object[] listElem; // 线性表存储空间

	private int curLen; // 当前长度

	// 顺序表的构造函数，构造一个存储空间容量为maxSize的线性表
	public SX1_SqList(int maxSize) {
		curLen = 0; // 置顺序表的当前长度为0
		listElem = new Object[maxSize];// 为顺序表分配maxSize个存储单元
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

	// 输出线性表中的数据元素
	public void display() {
		for (int j = 0; j < curLen; j++)
			System.out.print(listElem[j] + " ");
		System.out.println();// 换行

	}
       public static void main(String[] args) throws Exception{
           SX1_SqList L=new SX1_SqList(20);
           System.out.println("请输入顺序表的长度:");
           L.curLen=new Scanner(System.in).nextInt();
           System.out.println("请输入顺序表中的各个数据元素:");
           for(int i=0;i<L.curLen;i++)
               L.listElem[i]=new Scanner(System.in).nextInt();
           System.out.println("请输入待插入的位置i:");
           int i=new Scanner(System.in).nextInt();
           System.out.println("请输入待插入的数据值x:");
           int x=new Scanner(System.in).nextInt();
           L.insert(i, x);
           System.out.println("插入后的顺序表为:");
           L.display();
           System.out.println("请输入待删除元素的位置:");
           i=new Scanner(System.in).nextInt();
           L.remove(i);
           System.out.println("删除后的顺序表为:");
           L.display();

       }
}