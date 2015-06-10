package ch05Exercise;

import ch05.CSTreeNode;

/**
 * 5.编写算法计算树(基于孩子兄弟链表存储结构)的深度。
 * 
 * @author zou
 * 
 */
public class Exercise5_3_5 {

	/**
	 * 5.	计算树(基于孩子兄弟链表存储结构)的深度。
	 * 
	 * @param T
	 *            树根结点
	 * @return 树的深度
	 */
	public int treeDepth(CSTreeNode T) {
		if (T != null) {
			int h1= treeDepth(T.getFirstchild());
			int h2= treeDepth(T.getNextsibling());
            return h1+1>h2?h1+1:h2;
		}
		return 0;
	}

	public static void main(String[] args) {
		CSTreeNode D = new CSTreeNode('D');
		CSTreeNode E = new CSTreeNode('E');
		CSTreeNode C = new CSTreeNode('C', D, E);
		CSTreeNode B = new CSTreeNode('B', null, C);
		CSTreeNode A = new CSTreeNode('A', B, null);

		Exercise5_3_5 e = new Exercise5_3_5();
		System.out.println("该树的深度为：" + e.treeDepth(A));
	}
}

// 调试结果：
// 该树的深度为：3
