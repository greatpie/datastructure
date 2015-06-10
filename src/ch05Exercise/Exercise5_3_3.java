package ch05Exercise;

import ch03.LinkStack;
import ch05.BiTreeNode;

/**
 * 3.编写算法求一棵二叉树的根结点root到一个指定结点p之间的路径并输出。
 * 
 * @author zou
 * 
 */
public class Exercise5_3_3 {

	/**
	 * 求根结点到指定结点的路径，求路径过程中，采用了后跟遍历的思想
	 * 
	 * @param root
	 *            二叉树根结点
	 * @param p
	 *            指定结点
	 * @return 根结点到指定结点的路径，其中根结点处于栈顶位置，指定结点处于栈底位置
	 */
	public LinkStack getPath(BiTreeNode root, BiTreeNode p) {
		BiTreeNode T = root;
		LinkStack S = new LinkStack();// 构造链栈
		if (T != null) {
			S.push(T); // 根结点进栈
			Boolean flag;// 访问标记
			BiTreeNode q = null;// q指向刚被访问的结点
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// 将栈顶结点的所有左孩子结点入栈
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // 空结点退栈
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();// 查看栈顶元素
					if (T.getRchild() == null || T.getRchild() == q) {
						if (T.equals(p)) {
							// 对栈S进行倒置，以保证根结点处于栈顶位置
							LinkStack S2 = new LinkStack();
							while (!S.isEmpty())
								S2.push(S.pop());
							return S2;
						}
						S.pop();// 移除栈顶元素
						q = T;// q指向刚被访问的结点
						flag = true;// 设置访问标记
					} else {
						S.push(T.getRchild());// 右孩子结点入栈
						flag = false;// 设置未被访问标记
					}
					if (!flag)
						break;
				}
			}
		}
		return null;
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

		Exercise5_3_3 e = new Exercise5_3_3();
		LinkStack S = e.getPath(A, H);
		System.out.println("结点A到H的路径为：");
		while (!S.isEmpty()) {
			BiTreeNode node = (BiTreeNode) S.pop();
			System.out.print(node.getData() + " ");
		}
		System.out.println();
	}
}

// 调试结果：
// 结点A到H的路径为：
// A C F H
