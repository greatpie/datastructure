package ch05;

/**
 * 
 * 二叉链式(孩子 - 兄弟)存储结构下的树结点
 * 
 */
public class CSTreeNode {
	private Object data;// 结点的数据元素

	private CSTreeNode firstchild, nextsibling; // 孩子兄弟结点

	public CSTreeNode() {// 构造一个空结点
		this(null);
	}

	public CSTreeNode(Object data) {// 构造一棵孩子及兄弟为空的结点
		this(data, null, null);
	}

	public CSTreeNode(Object data, CSTreeNode firstchild, CSTreeNode nextsibling) {// 构造一棵数据元素和孩子及兄弟都不为空的结点
		this.data = data;
		this.firstchild = firstchild;
		this.nextsibling = nextsibling;
	}

	public Object getData() {
		return data;
	}

	public CSTreeNode getFirstchild() {
		return firstchild;
	}

	public CSTreeNode getNextsibling() {
		return nextsibling;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setFirstchild(CSTreeNode firstchild) {
		this.firstchild = firstchild;
	}

	public void setNextsibling(CSTreeNode nextsibling) {
		this.nextsibling = nextsibling;
	}
}
