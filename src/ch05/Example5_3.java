package ch05;

/**
 * 
 * 【例5-3】 编写成员函数完成求二叉树的深度
 */
public class Example5_3 {

	public int getDepth(BiTreeNode T) {
		if (T != null) {
			int lDepth = getDepth(T.getLchild());// 左子树的深度
			int rDepth = getDepth(T.getRchild());// 右子树的深度
			return 1 + (lDepth > rDepth ? lDepth : rDepth);// 返回左子树的深度和右子树的深度中的最大值加1
		}
		return 0;
	}

	public static void main(String[] args) {
		BiTree biTree = new BiTreeCreator().createBiTree();// 创建一棵树
		BiTreeNode root = biTree.getRoot();// 取得树的根结点

		// 调试【例5-3】 编写成员函数完成求二叉树的深度
		Example5_3 e = new Example5_3();
		System.out.println("树中的深度为： " + e.getDepth(root));
	}
}
// 运行结果：
// 树中的深度为： 5
