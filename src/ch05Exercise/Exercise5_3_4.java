package ch05Exercise;

import ch05.CSTreeNode;

/**
 * 4.编写算法统计树(基于孩子兄弟链表存储结构)的叶子数目。
 * 
 * @author zou
 * 
 */
public class Exercise5_3_4 {

	/**
	 * 统计树(基于孩子兄弟链表存储结构)叶结点数目
	 * 
	 * @param T
	 *            树根结点
	 * @return 叶结点数目
	 */
	public int countLeafNode(CSTreeNode T) {
		int count = 0;
		if (T != null) {
			if (T.getFirstchild() == null)
				++count;// 叶结点数增1
			else
				count += countLeafNode(T.getFirstchild()); // 加上孩子上叶结点数
			    count += countLeafNode(T.getNextsibling());// 加上兄弟上叶结点数
		}
		return count;
	}

	public static void main(String[] args) {
		CSTreeNode D = new CSTreeNode('D');
		CSTreeNode E = new CSTreeNode('E');
		CSTreeNode C = new CSTreeNode('C', D, E);
		CSTreeNode B = new CSTreeNode('B', null, C);
		CSTreeNode A = new CSTreeNode('A', B, null);

		Exercise5_3_4 e = new Exercise5_3_4();
		System.out.println("该树的叶结点的数目为：" + e.countLeafNode(A));
	}
}

// 调试结果：
// 该树的叶结点的数目为：3
