package ch05Exercise;

import ch05.BiTreeNode;

/**
 * 1. 编写一个程序实现：先建立两棵以二叉链表存储结构表示的二叉树，然后判断这两棵二叉树是否相等并输出测试结果。

 */
public class Exercise5_4_1 {
    public boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
		if (T1 == null && T2 == null)// 同时为空
			return true;
		if (T1 != null && T2 != null) // 同时非空进行比较
			if (T1.getData().equals(T2.getData()))// 根结点数据元素是否相等
				if (isEqual(T1.getLchild(), T2.getLchild())) // 左子树是否相等
					if (isEqual(T1.getRchild(), T2.getRchild()))// 右子树是否相等
						return true;
		return false;
	}

	public static void main(String[] args) {
		// 创建根结点为T1的二叉树
		BiTreeNode D1 = new BiTreeNode('D');
		BiTreeNode G1 = new BiTreeNode('G');
		BiTreeNode H1 = new BiTreeNode('H');
		BiTreeNode E1 = new BiTreeNode('E', G1, null);
		BiTreeNode B1 = new BiTreeNode('B', D1, E1);
		BiTreeNode F1 = new BiTreeNode('F', null, H1);
		BiTreeNode C1 = new BiTreeNode('C', F1, null);
		BiTreeNode T1 = new BiTreeNode('A', B1, C1);
		// 创建根结点为T2的二叉树
		BiTreeNode D2 = new BiTreeNode('D');
		BiTreeNode G2 = new BiTreeNode('G');
		BiTreeNode H2= new BiTreeNode('H');
		BiTreeNode E2 = new BiTreeNode('E', G2, null);
		BiTreeNode B2 = new BiTreeNode('B', D2, E2);
		BiTreeNode F2 = new BiTreeNode('F', null, H2);
		BiTreeNode C2 = new BiTreeNode('C', F2, null);
		BiTreeNode T2 = new BiTreeNode('A', B2, C2);
       // 创建根结点为T3的二叉树
		BiTreeNode E3= new BiTreeNode('E');
		BiTreeNode F3 = new BiTreeNode('F');
		BiTreeNode D3= new BiTreeNode('D',F3,null);
		BiTreeNode B3 = new BiTreeNode('B', null, D3);
		BiTreeNode C3 = new BiTreeNode('C', null, E3);
		BiTreeNode T3 = new BiTreeNode('A', B3, C3);
        Exercise5_4_1 e = new Exercise5_4_1();
		if (e.isEqual(T1, T2))
			System.out.println("T1、T2两棵二叉树相等！");
		else
			System.out.println("T1、T2两棵二叉树不相等！");
        if (e.isEqual(T1, T3))
			System.out.println("T1、T3两棵二叉树相等！");
		else
			System.out.println("T1、T3两棵二叉树不相等！");
	}
}
