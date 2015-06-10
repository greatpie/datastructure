package ch03Exercise;



/**
 * 
 * 1.在顺序栈类中增加一个main成员函数，使其实际运行来测试顺序栈类中各成员函数的正确性。
 
 */
//顺序栈类
class SqStack  {

	private Object[] stackElem; // 栈存储空间

	private int top; // 非空栈中始终表示栈顶元素的下一个位置，当栈为空时其值为0

	// 栈的构造函数，构造一个存储空间容量为maxSize的栈
	public SqStack(int maxSize) {
		top = 0; // 初始化top为0
		stackElem = new Object[maxSize];// 为栈分配maxSize个存储单元
	}

	// 将一个已经存在的栈置成空
	public void clear() {
		top = 0;
	}

	// 测试栈是否为空
	public boolean isEmpty() {
		return top == 0;
	}

	// 求栈中的数据元素个数并由函数返回其值
	public int length() {
		return top;
	}

	// 查看栈顶对象而不移除它，返回栈顶对象
	public Object peek() {
		if (!isEmpty())// 栈非空
			return stackElem[top - 1]; // 栈顶元素
		else
			// 栈为空
			return null;
	}

	// 移除栈顶对象并作为此函数的值返回该对象
	public Object pop() {
		if (top == 0)// 栈为空
			return null;
		else {// 栈非空
			return stackElem[--top];// 修改栈顶指针，并返回栈顶元素
		}
	}

	// 把项压入栈顶
	public void push(Object o) throws Exception {
		if (top == stackElem.length)// 栈满
			throw new Exception("栈已满");// 输出异常
		else
			// 栈未满
			stackElem[top++] = o;// o赋给栈顶元素后，top增1
	}

	// 打印函数，打印所有栈中的元素(栈顶到栈底)
	public void display() {
		for (int i = top - 1; i >= 0; i--)
			System.out.print(stackElem[i].toString() + " ");// 打印
	}

}
//测试类
public class Exercise3_4_1 {
     public static void main(String[] args) throws Exception {
		SqStack S = new SqStack(100); // 初始化一个新的栈
		for (int i = 1; i <= 10; i++)
			// 初始化栈中的元素，其中元素个数为10
			S.push(i);
		System.out.println("栈中各元素为(栈顶到栈底)： ");
		S.display();// 打印栈中元素（栈低到栈顶）
		System.out.println();

		if (!S.isEmpty())// 栈非空，输出
			System.out.println("栈非空！");

		System.out.println("栈的长度为： " + S.length());// 输出栈的长度
		System.out.println("栈顶元素为： " + S.peek().toString());// 输出栈顶元素

		System.out.println("去除栈顶元素后，栈中各元素为(栈顶到栈底)：  ");
		S.pop();// 删除元素
		S.display();// 打印栈中元素
		System.out.println();

		System.out.println("去除栈中剩余的所有元素！ 进行中。。。"); // 输出
		S.clear(); // 清除栈中的元素

		if (S.isEmpty())// 栈空，输出
			System.out.println("栈已清空!");
	}
}
// 调试结果：
// 栈中各元素为(栈顶到栈底)：
// 10 9 8 7 6 5 4 3 2 1
// 栈非空！
// 栈的长度为： 10
// 栈顶元素为： 10
// 去除栈顶元素后，栈中各元素为(栈顶到栈底)：
// 9 8 7 6 5 4 3 2 1
// 去除栈中剩余的所有元素！ 进行中。。。
// 栈已清空!