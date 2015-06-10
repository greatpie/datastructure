package ch05;

/**
 * 
 * 【例5-6】编写一个程序：首先由标明空子树的先根遍历序列建立一棵二叉树，然后输出该二叉树的先根、中根和后根遍历序列。
 */
public class Example5_6 {


	public static void main(String[] args) {
		String preStr = "AB##CD###";// 标明空子树的先根遍历序列
		BiTree T = new BiTree(preStr);
		System.out.println("先根遍历： ");
		T.preRootTraverse();// 调用二叉树的先根遍历函数
		System.out.println();

		System.out.println("中根遍历： ");
		T.inRootTraverse();// 调用二叉树的中根遍历函数
		System.out.println();

		System.out.println("后根遍历： ");
		T.postRootTraverse();// 调用二叉树的后根遍历函数
		System.out.println();
	}
}

// 运行结果：
// 先根遍历：
// ABCD
// 中根遍历：
// BADC
// 后根遍历：
// BDCA
