package ch05Exercise;
import ch05.CSTreeNode;
/**
 * 2.编写一个程序实现：先建立一棵以孩子兄弟链表存储结构表示的树，然后输出这棵树的先根遍历序列和后根遍历序列。
 * 

 */

public class Exercise5_4_2 {
   
    public CSTreeNode createBiTree() {
		CSTreeNode D = new CSTreeNode('D');
		CSTreeNode E = new CSTreeNode('E');
		CSTreeNode C = new CSTreeNode('C', D, E);
		CSTreeNode B = new CSTreeNode('B', null, C);
		CSTreeNode A = new CSTreeNode('A', B, null);
		return A;
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
	public static void main(String[] args) {
		Exercise5_4_2 e = new Exercise5_4_2();
		CSTreeNode root=e.createBiTree();
        		// 调试先根遍历
		System.out.println("该树的先根遍历为：");
		e.preRootTraverse(root);

		// 调试后根遍历
		System.out.println("\n该树的后根遍历为：");
		e.postRootTraverse(root);

	}
}
