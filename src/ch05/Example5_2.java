package ch05;

/**
 * 
 * 【例5-2】 编写成员函数计算二叉树中结点的个数
 * 
 */
public class Example5_2 {

	// 采用先根遍历的方式对树进行遍历，计算树中的结点数
	public int countNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			++count;// 结点数增1
			count += countNode(T.getLchild()); // 加上左子树上结点数
			count += countNode(T.getRchild());// 加上右子树上的结点数
		}
		return count;
	}

	public static void main(String[] args) {
		BiTree biTree = new BiTreeCreator().createBiTree();// 创建一棵树
		BiTreeNode root = biTree.getRoot();// 取得树的根结点

		// 调试【例5-1 】编写成员函数完成在二叉树中查找数据元素值为x的结点的操作
		Example5_2 e = new Example5_2();
		System.out.println("树中的结点个数为： " + e.countNode(root));
	}
}
// 运行结果：
// 树中的结点个数为： 13
