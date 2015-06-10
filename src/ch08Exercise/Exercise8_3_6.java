package ch08Exercise;

/**
 * 3_6: 基于BSTree类，设计一个算法，在二叉排序树中以非递归方式查找值为key的结点
 * @author dux
 */
import ch05.*;
import ch07.*;
import ch08.*;

public class Exercise8_3_6 extends BSTree {

    public Object searchBSTNonRecur(BiTreeNode p, Comparable key) {
        while (p != null) {
            if (key.compareTo(((RecordNode) p.getData()).getKey()) == 0) //查找成功
            {
                return p.getData();
            } else if (key.compareTo(((RecordNode) p.getData()).getKey()) < 0) {
                p = p.getLchild();     //在左子树中查找
            } else {
                p = p.getRchild();    //在右子树中查找
            }
        }
        return null;
    }

    public static void main(String args[]) {
        BSTree bstree = new BSTree();
        int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};  //关键字数组
        String[] item = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou"}; //数据元素
        KeyType[] key = new KeyType[k.length];          //关键字数组
        ElementType[] elem = new ElementType[k.length]; //记录数据数组
        System.out.println("原序列： ");
        for (int i = 0; i < k.length; i++) {
            key[i] = new KeyType(k[i]);            //创建关键字对象
            elem[i] = new ElementType(item[i]);    //创建记录数据对象
            if (bstree.insertBST(key[i], elem[i])) { //若插入对象成功
                System.out.print("[" + key[i] + "," + elem[i] + "]");
            }
        }
        System.out.println("");
        Exercise8_3_6 sbt = new Exercise8_3_6();
        KeyType keyvalue = new KeyType();
        keyvalue.setKey(63);
        RecordNode found = (RecordNode) sbt.searchBSTNonRecur(bstree.getRoot(), keyvalue);
        if (found != null) {
            System.out.println("查找关键码：" + keyvalue + ",成功！ 对应姓氏为:" + found.getElement());
        } else {
            System.out.println("查找关键码：" + keyvalue + ",失败!");
        }
        keyvalue.setKey(39);
        found = (RecordNode) sbt.searchBSTNonRecur(bstree.getRoot(), keyvalue);
        if (found != null) {
            System.out.println("查找关键码：" + keyvalue + ",成功！ 对应姓氏为:" + found.getElement());
        } else {
            System.out.println("查找关键码：" + keyvalue + ",失败!");
        }
    }
}

//测试结果：
/*
原序列：
[50,Wang][13,Li][63,Zhang][8,Liu][36,Chen][90,Yang][5,Huang][10,Zhao][18,Wu][70,Zhou]
查找关键码：63,成功！ 对应姓氏为:Zhang
查找关键码：39,失败!
 */