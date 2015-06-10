package ch08Exercise;

import ch05.*;
import ch07.*;
import ch08.*;

/**
 *  3.4：基于BSTree类，设计一个算法，输出给定二叉排序树中值最大的结点。
 * @author dux
 */
public class Exercise8_3_4 extends BSTree {

    BiTreeNode maxNode(BiTreeNode T) {
        if (T == null) {
            System.out.println("这是一颗空树.");
            return null;
        } else {
            BiTreeNode q = T;
            while (q.getRchild() != null) {
                q = q.getRchild();
            }
            return q;
        }
    }

    public static void main(String args[]) {
        BSTree bstree = new BSTree();
        int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};  //关键字数组

        KeyType[] key = new KeyType[k.length];          //关键字数组
        for (int i = 0; i < k.length; i++) {
            key[i] = new KeyType(k[i]);            //建立二叉排序树
            bstree.insertBST(key[i], "");
        }
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i] + " ");
        }
        System.out.println("");
        Exercise8_3_4 sbt = new Exercise8_3_4();
        int maxk = ((KeyType) ((RecordNode) (sbt.maxNode(bstree.getRoot()).getData())).getKey()).getKey();
        System.out.println("以上关键码序列中最大关键码是：" + maxk);
    }
}

//测试结果：
/*
50 13 63 8 36 90 5 10 18 70
以上关键码序列中最大关键码是：90
 */