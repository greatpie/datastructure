package ch03Exercise;

import java.util.Scanner;

/**
 *  4.循环顺序队列类采用设置一个计数器的方法来区分循环队列的判空和判满。试分别编写顺序循环队列中入队和出队操作的函数。
 
 */
class CircleSqQueue_num  {
	private Object[] queueElem; // 队列存储空间
	private int front;// 队首的引用，若队列不空，指向队首元素
    private int rear;// 队尾的引用，若队列不空，指向队尾元素的下一个位置
	private int num; // 计数器用来记录队列中的数据元素个数

	// 循环队列类的构造函数
	public CircleSqQueue_num(int maxSize) {
		num = 0;
		front =rear= 0;// 队首、队尾初始化为0
		queueElem = new Object[maxSize];// 为队列分配maxSize个存储单元
	}

	
	// 把指定的元素x插入队列
	public void offer(Object x) throws Exception {
		if (num==queueElem.length)// 队列满
			throw new Exception("队列已满");// 输出异常
		else {// 队列未满
			queueElem[rear] = x;// x加入队尾
			rear=(rear + 1) % queueElem.length;  //更改队尾的位置
            ++num;  //计数器加1
		}
   }
	
	// 移除队首元素并作为此函数的值返回该对象，如果此队列为空，则返回 null
	public Object poll() {
		if (num==0)// 队列为空
			return null;
		else {
			Object t = queueElem[front];// 取出队首元素
			front = (front + 1) % queueElem.length;// 更改队首的位置
			--num;    //计数器减1
			return t;// 返回队首元素
		}
	}

	// 打印函数，打印所有队列中的元素(队首到队尾)
	public void display() {
		if (num!=0) {
			// 从队首到队尾
			for (int i = front; i != (front + num) % queueElem.length; i = (i + 1)
					% queueElem.length)
				System.out.print(queueElem[i].toString() + " ");
		} else {
			System.out.println("此队列为空");
		}
	}
}
public class Exercise3_3_4 {
  
    public static void main(String[] args) throws Exception {
      CircleSqQueue_num Q = new CircleSqQueue_num(100);
		for (int i = 1; i <= 10; i++)
			// 初始化队列中的元素，其中元素个数为10
			Q.offer(i);
		System.out.println("队列中各元素为(从队首到队尾)： ");
		Q.display();// 打印队列中元素（队首到队尾）
		System.out.println();
		System.out.print("请输入待入队的元素值：");
        Q.offer(new Scanner(System.in).next());
		System.out.println("入队后队列中各元素为(从队首到队尾)：");
        Q.display();// 打印队列中元素（队首到队尾）
		System.out.println();
		Q.poll();// 删除元素
		System.out.println("出队后队列中各元素为(从队首到队尾)：");
        Q.display();// 打印队列中元素
		System.out.println();
		}
}

//调试运行结果：
//队列中各元素为(队首到队尾)：
//1 2 3 4 5 6 7 8 9 10
//请输入待入队的元素值：55
//入队后队列中各元素为(队首到队尾)：
//1 2 3 4 5 6 7 8 9 10 55
//出队后队列中各元素为(队首到队尾)：
//2 3 4 5 6 7 8 9 10 55
