package ch05;

import ch03.LinkQueue;

/**
 * 
 * 二叉链式(孩子 - 兄弟)存储结构下的树
 * 
 */
public class CSTree {
	private CSTreeNode root;// 树的根结点

	public CSTree() {// 构造一棵空树
		this(null);
	}

	public CSTree(CSTreeNode root) {// 构造一棵树
		this.root = root;
	}

	// 先根遍历树的递归算法
	public void preRootTraverse(CSTreeNode T) {
		if (T != null) {
			System.out.print(T.getData()); // 访问根结点
			preRootTraverse(T.getFirstchild());// 访问孩子结点
			preRootTraverse(T.getNextsibling());// 访问兄弟结点
		}
	}

	// 后根遍历树的递归算法
	public void postRootTraverse(CSTreeNode T) {
		if (T != null) {
			postRootTraverse(T.getFirstchild());// 访问孩子结点
			System.out.print(T.getData()); // 访问根结点
			postRootTraverse(T.getNextsibling());// 访问兄弟结点
		}
	}

	// 层次遍历
	public void levelTraverse() {
		CSTreeNode T = root;
		if (T != null) {
			LinkQueue L = new LinkQueue();// 构造队列
			L.offer(T);// 根结点入队列
			while (!L.isEmpty())
				for (T = (CSTreeNode) L.poll(); T != null; T = T
						.getNextsibling()) {// 访问结点及其所有兄弟结点
					System.out.print(T.getData()); // 访问结点
					if (T.getFirstchild() != null)// 第一个孩子结点非空入队列
						L.offer(T.getFirstchild());
				}
		}
	}

	public CSTreeNode getRoot() {
		return root;
	}

	public void setRoot(CSTreeNode root) {
		this.root = root;
	}
}
