package ch03Exercise;

import ch02.Node;
import java.util.Scanner;

/**
 * 
 *5.假设采用带头结点的循环链表来表示队列，并且只设一个指向队尾元素的指针（不设队首指针），试编写相应的队列置空、队列判空、入队和出队操作的函数。
 
 */
class CircleLinkQueue {
	private Node rear;// 循环链队列的尾指针

	// 构造方法
	public CircleLinkQueue() {//构造一个带头结点的空循环链队列
		rear = new Node(); // 初始化头结点并用尾指针指向它
		rear.setNext(rear);
	}

	// 队列置空操作方法
	public void clear() {//将一个已经存在的带头结点的循环链队列置成空队列
		rear.setNext(rear);
	}

	// 入队操作方法
	public void offer  ( Object x) throws Exception {
		//将指定的元素x插入到带头结点的循环链队列中
        Node p= new Node(x); // 生成新结点
		p.setNext(rear.getNext());// 插入链列列的尾部
		rear.setNext(p);
        rear=p;
	}

	// 出队操作方法
	public void poll() throws Exception {
       // 移除带头结点的循环链队列中的队首元素并作为此函数的值返回该对象，如果此队列为空，则返回 null
		Node p = rear.getNext().getNext();// p指向待删除的队首结点
		if (p==rear)
            rear.setNext(rear);  //删除队首结点后，链队列变成了空链队列
        else
            
		     rear.getNext().setNext(p.getNext());// 删除队首结点
	}
// 打印函数，打印所有队列中的元素(队首到队尾)
	public void display() {
		if (rear.getNext()!=rear) {
			for (Node p=rear.getNext().getNext();p!=rear.getNext();p=p.getNext())
				// 从队首到队尾
				System.out.print(p.getData()+ " ");
		} else {
			System.out.println("此队列为空");
		}
	}
}
public class Exercise3_3_5 {
   public static void main(String[] args) throws Exception {
      CircleLinkQueue Q = new CircleLinkQueue();
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
//调试运行结果:
//队列中各元素为(从队首到队尾)：
//1 2 3 4 5 6 7 8 9 10
//请输入待入队的元素值：55
//入队后队列中各元素为(从队首到队尾)：
//1 2 3 4 5 6 7 8 9 10 55
//出队后队列中各元素为(从队首到队尾)：
//2 3 4 5 6 7 8 9 10 55
