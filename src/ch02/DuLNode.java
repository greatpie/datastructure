package ch02;

/**
 * 
 * 双向链表的结点
 * 
 */
public class DuLNode {
	private Object data;// 存放结点值

	private DuLNode prior; // 前驱结点的引用

	private DuLNode next; // 后继结点的引用

	public DuLNode() {// 无参数时的构造函数
		this(null);
	}

	public DuLNode(Object data) {// 构造值为data的结点
		this.data = data;
		this.prior = null;
		this.next = null;
	}

	public Object getData() {
		return data;
	}

	public DuLNode getNext() {
		return next;
	}

	public DuLNode getPrior() {
		return prior;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setNext(DuLNode next) {
		this.next = next;
	}

	public void setPrior(DuLNode prior) {
		this.prior = prior;
	}
}
