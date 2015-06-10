package ch05;

/**
 * 
 * 二叉链式(孩子 - 兄弟)存储结构下的树的各操作
 * 
 */
public class DebugCSTree {
	// 初始化一棵树，并返回其根结点
	public CSTree createBiTree() {
		CSTreeNode D = new CSTreeNode('D');
		CSTreeNode E = new CSTreeNode('E');
		CSTreeNode C = new CSTreeNode('C', D, E);
		CSTreeNode B = new CSTreeNode('B', null, C);
		CSTreeNode A = new CSTreeNode('A', B, null);
		return new CSTree(A);
	}

	public static void main(String[] args) {
		DebugCSTree debugCSTree = new DebugCSTree();
		CSTree csTree = debugCSTree.createBiTree();
		CSTreeNode root = csTree.getRoot();// 取得树的根结点

		// 调试先根遍历
		System.out.println("该树的先根遍历为：");
		csTree.preRootTraverse(root);

		// 调试后根遍历
		System.out.println("\n该树的后根遍历为：");
		csTree.postRootTraverse(root);

		// 调试层次遍历
		System.out.println("\n该树的层次遍历为：");
		csTree.levelTraverse();
	}
}

// 运行结果：
// 该树的先根遍历为：
// ABCDE
// 该树的后根遍历为：
// BDCEA
// 该树的层次遍历为：
// ABCED
