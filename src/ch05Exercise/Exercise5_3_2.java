package ch05Exercise;

import ch05.BiTreeNode;
import java.util.Scanner;

/**
 * 2.编写一个基于二叉树类的查找二叉树结点的成员函数
 * 
 
 */
public class Exercise5_3_2 {
   public BiTreeNode searchNode(BiTreeNode T,Object x) { 
	// 在以T为根结点的二叉树中查找值为x的结点,若找到,则返回该结点,否则返回空值
       	if (T != null) {
			if (T.getData().equals(x))
				return T;
			else {
				BiTreeNode lresult= searchNode(T.getLchild(),x); // 在左子树上查找
				return (lresult!=null?lresult:searchNode(T.getRchild(),x)) ;// 若左子树上没找到,则到右子树上找
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

		Exercise5_3_2  e = new Exercise5_3_2();
        System.out.println("请输入待查找的结点值：");
        BiTreeNode p=e.searchNode(A, (new Scanner(System.in).next()).charAt(0));
		if (p!=null)
           System.out.println("查找成功");
        else
          System.out.println("查找失败");

	}

}

// 调试结果：

