package ch03;

/**
 * 
 * 充当优先队列结点类Node的数据域data
 * 
 */
public class PriorityQData {
	private Object elem;// 结点的值

	private int priority;// 结点的优先级

	// 构造函数
	public PriorityQData(Object elem, int priority) {
		this.elem = elem;
		this.priority = priority;
	}

	public Object getElem() {
		return elem;
	}

	public int getPriority() {
		return priority;
	}

	public void setElem(Object elem) {
		this.elem = elem;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
