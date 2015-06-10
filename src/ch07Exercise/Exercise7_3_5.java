package ch07Exercise;
/*
 * 3.5: 试设计算法，判断完全二叉树是否为大顶堆。
 * @author dux
 */
import ch05.*;
import ch07.*;

public class Exercise7_3_5 {

    public BiTree createBiTree() {   //建立一颗完全二叉树
        int[] k = {50, 40, 45, 30, 32, 34, 36};  //关键字数组
        KeyType[] key = new KeyType[k.length];         
        for (int i = 0; i < k.length; i++) {
            key[i] = new KeyType(k[i]);            
        }
        BiTreeNode N3 = new BiTreeNode(new RecordNode(key[3]));
        BiTreeNode N4 = new BiTreeNode(new RecordNode(key[4]));
        BiTreeNode N5 = new BiTreeNode(new RecordNode(key[5]));
        BiTreeNode N6 = new BiTreeNode(new RecordNode(key[6]));
        BiTreeNode N1 = new BiTreeNode(new RecordNode(key[1]), N3, N4);
        BiTreeNode N2 = new BiTreeNode(new RecordNode(key[2]), N5, N6);
        BiTreeNode root = new BiTreeNode(new RecordNode(key[0]), N1, N2);
        return new BiTree(root);
    }

    boolean checkmax(BiTreeNode t)    //判断完全二叉树是否为大顶堆
    {
        BiTreeNode p = t;
        if (p.getLchild() == null && p.getRchild() == null) {
            return true;
        } else {
            if (p.getLchild() != null && p.getRchild() != null) {
                if ((((RecordNode) p.getLchild().getData()).getKey()).compareTo(((RecordNode) p.getData()).getKey()) <= 0 && (((RecordNode) p.getRchild().getData()).getKey()).compareTo(((RecordNode) p.getData()).getKey()) <= 0) {                   
                    return checkmax(p.getLchild()) && checkmax(p.getRchild());
                } else 
                {
                    return false;
                }
            } else if (p.getLchild() != null && p.getRchild() == null) {
                if ((((RecordNode) p.getLchild().getData()).getKey()).compareTo(((RecordNode) p.getData()).getKey()) <= 0) {
                    return checkmax(p.getLchild());
                } else 
                {
                    return false;
                }

            } else if (p.getLchild() == null && p.getRchild() != null) {
                if ((((RecordNode) p.getRchild().getData()).getKey()).compareTo(((RecordNode) p.getData()).getKey()) <= 0) {
                    return checkmax(p.getRchild());
                } else 
                {
                    return false;
                }
              
            } else {
                return false;
            }
        }
    }

    public static void main(String args[]) {
        Exercise7_3_5 ex = new Exercise7_3_5();
        BiTree biTree = ex.createBiTree();// 创建一棵完全二叉树
        BiTreeNode root = biTree.getRoot();    // 取得树的根结点
        biTree.preRootTraverse(root);
        if(ex.checkmax(root))
          System.out.println("是大顶堆");
        else
          System.out.println("不是大顶堆");
    }
}

//测试结果：
/*
 * [50,null] [40,null] [30,null] [32,null] [45,null] [34,null] [36,null] 是大顶堆
 */