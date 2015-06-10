package ch03Exercise;

import java.util.Scanner;

/**
 * 
 * 3.设计一个循环顺序队列类。要求： (1) 循环顺序队列类采用设置标志位的方法来区分循环队列的判空和判满条件。 (2)
 * 循环顺序队列类除构造函数外，成员函数还应包括入队、出队和判队列是否为空的函数。 (3) 设计一个测试程序进行测试，并给出测试结果。
 * 
 * 
 * @author zou
 * 
 */
//循环顺序队列类(采用设置标志位的方法来区分循环队列的判空和判满条件)
class CircleSqQueue_flag {
	private Object[] queueElem; // 队列存储空间

	private int front;// 队头的引用，若队列不空，指向队首元素
    private int rear;// 队尾的引用，若队列不空，指向队尾元素的下一个位置
    private int flag; // 队列判空与判满的标志量,当入列操作后其值置为1,出队操作后其值置为0

	// 循环队列类的构造函数
	public CircleSqQueue_flag(int maxSize) {
		queueElem = new Object[maxSize];// 为队列分配maxSize个存储单元
		front =rear= 0;// 队头、队尾初始化为0
        flag = 0;

	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front==rear&&flag==0;
	}

	// 判断队列是否已满
	public boolean isFull() {
		return front==rear&&flag==1;
	}

	// 把指定的元素x插入队列
	public void offer(Object x) throws Exception {
		if (isFull())// 队列满
			throw new Exception("队列已满");// 输出异常
		else {// 队列未满
			queueElem[rear] = x;// x赋给队尾元素
			rear = (rear + 1) % queueElem.length;// 修改队尾指针
            flag=1;  //修改标志位值
		}
	}

	// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回 null
	public Object poll() {
		if (isEmpty())// 队列为空
			return null;
		else {
			Object t = queueElem[front];// 取出队首元素
			front = (front + 1) % queueElem.length;// 更改队首的位置
			flag=0; //修改标志位值
			return t;// 返回队首元素
		}
	}

	// 打印函数，打印所有队列中的元素(队首到队尾)
	public void display() {
		if (!isEmpty()) {  //队列非空
			// 从队首到队尾
            int i = front;
			do {
				System.out.print(queueElem[i].toString() + " ");
                i = (i + 1)% queueElem.length;}
            while(i!=rear);
		}
        else {
			System.out.println("此队列为空");
		}
	}
}
//测试类
public class Exercise3_4_3 {
	public static void main(String[] args) throws Exception {
		CircleSqQueue_flag Q = new CircleSqQueue_flag(100);
		for (int i = 1; i <= 10; i++)
			// 初始化队列中的元素，其中元素个数为10
			Q.offer(i);
		System.out.println("队列中各元素为(队首到队尾)： ");
		Q.display();// 打印队列中元素（队首到队尾）
		System.out.println();
		if (!Q.isEmpty())// 队列非空，输出
			System.out.println("队列非空！");
		System.out.print("输入待入栈的元素值：  ");
        Q.offer(new Scanner(System.in).next());// 删除元素
	    System.out.println("入队后，队列中各元素为(队首到队尾)：  ");	
        Q.display(); // 打印队列中元素
		System.out.println();
        System.out.println("去除队首元素后，队列中各元素为(队首到队尾)：  ");
		Q.poll();// 队首元素出队
		Q.display();// 打印队列中元素
		System.out.println();

	}
}

//测试运行结果:
//队列中各元素为(队首到队尾)：
//1 2 3 4 5 6 7 8 9 10
//队列非空！
//输入待入栈的元素值：  55
//入队后，队列中各元素为(队首到队尾)：
//1 2 3 4 5 6 7 8 9 10 55
//去除队首元素后，队列中各元素为(队首到队尾)：
//2 3 4 5 6 7 8 9 10 55

