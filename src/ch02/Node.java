package ch02;

/**
 * 
 * 单链表的结点
 * 
 */
public class Node {
	private Object data; // 存放结点值

	private Node next; // 后继结点的引用

	public Node() { // 无参数时的构造函数
		this(null, null);
	}

	public Node(Object data) { // 构造值为data的结点
		this(data, null);
	}

	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
