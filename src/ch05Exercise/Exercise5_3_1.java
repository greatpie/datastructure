package ch05Exercise;

import ch05.BiTreeNode;

/**
 * 1.编写一个基于二叉树类的统计叶结点数目的成员函数
 * @see ch05.BiTree#countLeafNode(BiTreeNode) 统计叶结点数目
 */
public class Exercise5_3_1 {
	
	public int countLeafNode(BiTreeNode T) { // 统计叶结点数目
		int count = 0;
		if (T != null) {
			if (T.getLchild() == null && T.getRchild() == null) {
				++count;// 叶结点数增1
			} else {
				count += countLeafNode(T.getLchild()); // 加上左子树上叶结点数
				count += countLeafNode(T.getRchild());// 加上右子树上的叶结点数
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// 创建根结点为A的二叉树
		BiTreeNode D = new BiTreeNode('D');
		BiTreeNode G = new BiTreeNode('G');
		BiTreeNode H = new BiTreeNode('H');
		BiTreeNode E = new BiTreeNode('E', G, null);
		BiTreeNode B = new BiTreeNode('B', D, E);
		BiTreeNode F = new BiTreeNode('F', null, H);
		BiTreeNode C = new BiTreeNode('C', F, null);
		BiTreeNode A = new BiTreeNode('A', B, C);

		Exercise5_3_1 e = new Exercise5_3_1();


		System.out.println("该树的叶结点的数目为：" + e.countLeafNode(A));

	}
}

// 调试结果：
// 该树的叶结点的数目为：3
