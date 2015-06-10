package ch05;

/**
 * 
 * 赫夫曼树的结点类
 * 
 */
public class HuffmanNode {
	private int weight;// 结点的权值

	private int flag;// 加入赫夫曼树的标志，flag=0时表示该结点未加入哈夫曼树，flag=1时则表示该结点已加入哈夫曼树

	private HuffmanNode parent, lchild, rchild; // 父结点及左右孩子结点

	public HuffmanNode() {// 构造一个空结点
		this(0);
	}

	public HuffmanNode(int weight) {// 构造一个具有权值的结点
		this.weight = weight;
		flag = 0;
		parent = lchild = rchild = null;
	}

	public int getFlag() {
		return flag;
	}

	public HuffmanNode getLchild() {
		return lchild;
	}

	public HuffmanNode getParent() {
		return parent;
	}

	public HuffmanNode getRchild() {
		return rchild;
	}

	public int getWeight() {
		return weight;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setLchild(HuffmanNode lchild) {
		this.lchild = lchild;
	}

	public void setParent(HuffmanNode parent) {
		this.parent = parent;
	}

	public void setRchild(HuffmanNode rchild) {
		this.rchild = rchild;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
