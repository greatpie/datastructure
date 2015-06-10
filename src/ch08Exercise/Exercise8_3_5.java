package ch08Exercise;

import ch05.*;
import ch07.*;
import ch08.*;

/**
 * 3.5：设计一个算法，求出指定结点在给定的二叉排序树中所在的层数。
 * @author dux
 */
public class Exercise8_3_5 extends BSTree {

    static int level = 0;          //层数
    static boolean found = false;  

    public static int levelOfNode(BiTreeNode p, Comparable key) {
        if (p != null && !found) {
            level++;
            if (key.compareTo(((RecordNode) p.getData()).getKey()) == 0) {
                found = true;
                ;
            } else {
                levelOfNode(p.getLchild(), key);     //在左子树中查找
                levelOfNode(p.getRchild(), key);     //在右子树中查找
                if (!found) {
                    level--;
                }
            }
        }
        return level;
    }

    public static void main(String args[]) {
        BSTree bstree = new BSTree();
        int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};  //关键字数组

        KeyType[] key = new KeyType[k.length];     //关键字数组
        for (int i = 0; i < k.length; i++) {
            key[i] = new KeyType(k[i]);            //建立二叉排序树
            bstree.insertBST(key[i], "");
        }
        System.out.print("在由关键码序列：{");
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i] + " ");
        }
        System.out.println("}组成的二叉排序树中");
        Exercise8_3_5 sbt = new Exercise8_3_5();
        KeyType keyvalue = new KeyType();
        int k1 = 18;
        keyvalue.setKey(k1);
        int keylevel = sbt.levelOfNode(bstree.getRoot(), keyvalue);
        System.out.println("关键码为" + k1 + "的结点所在的层数是：" + keylevel);
    }
}

//测试结果：
/*
在由关键码序列：{50 13 63 8 36 90 5 10 18 70 }组成的二叉排序树中
关键码为18的结点所在的层数是：4
 */