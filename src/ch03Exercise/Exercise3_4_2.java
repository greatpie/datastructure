package ch03Exercise;

import ch02.Node;

/**
 * 
 * 2.在链队列类中增加一个main成员函数，使其实际运行来测试链队列类中各成员函数的正确性。
 */
//链队列类
class LinkQueue  {
	private Node front;// 队头的引用

	private Node rear;// 队尾的引用，指向队尾元素

	// 链队列类的构造函数
	public LinkQueue() {
		front = rear = null;
	}

	// 将一个已经存在的队列置成空
	public void clear() {
		front = rear = null;

	}

	// 测试队列是否为空
	public boolean isEmpty() {
		return front == null;
	}

	// 求队列中的数据元素个数并由函数返回其值
	public int length() {
		Node p = front;
		int length = 0;// 队列的长度
		while (p != null) {// 一直查找到队尾
			p = p.getNext();
			++length;// 长度增1
		}
		return length;
	}

	// 把指定的元素插入队列
	public void offer(Object o) {
		Node p = new Node(o);// 初始化新的结点
		if (front != null) {// 队列非空
			rear.setNext(p);
			rear = p;// 改变队尾的位置
		} else
			// 队列为空
			front = rear = p;
	}

	// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回 null
	public Object peek() {
		if (front != null) // 队列非空
			return front.getData();// 返回队列元素
		else
			return null;
	}

	// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null
	public Object poll() {
		if (front != null) { // 队列非空
			Node p = front;// p指向队首结点
			front = front.getNext();
			return p.getData();// 返回队首结点数据
		} else
			return null;
	}

	// 打印函数，打印所有队列中的元素(队首到队尾)
	public void display() {
		if (!isEmpty()) {
			Node p = front;
			while (p != rear.getNext()) {// 从对头到队尾
				System.out.print(p.getData().toString() + " ");
				p = p.getNext();
			}
		} else {
			System.out.println("此队列为空");
		}
	}
}
//测试类
public class Exercise3_4_2 {
   public static void main(String[] args) {
		LinkQueue Q = new LinkQueue();
		for (int i = 1; i <= 10; i++)
			// 初始化队列中的元素，其中元素个数为10
			Q.offer(i);
		System.out.println("队列中各元素为(队首到队尾)： ");
		Q.display();// 打印队列中元素（队首到队尾）
		System.out.println();
		if (!Q.isEmpty())
			System.out.println("队列非空！");

		System.out.println("队列的长度为： " + Q.length());// 输出队列的长度
		System.out.println("队首元素为： " + Q.peek().toString());// 输出队首元素

		System.out.println("去除队首元素后，队列中各元素为(队首到队尾)：  ");
		Q.poll();// 删除元素
		Q.display();// 打印队列中元素
		System.out.println();

		System.out.println("去除队列中剩余的所有元素！ 进行中。。。"); // 输出
		Q.clear(); // 清除队列中的元素

		if (Q.isEmpty())// 队列空，输出
			System.out.println("队列已清空!");
	}

}
// 调试结果：
// 队列中各元素为(队首到队尾)：
// 1 2 3 4 5 6 7 8 9 10
// 队列非空！
// 队列的长度为： 10
// 队首元素为： 1
// 去除队首元素后，队列中各元素为(队首到队尾)：
// 2 3 4 5 6 7 8 9 10
// 去除队列中剩余的所有元素！ 进行中。。。
// 队列已清空!
