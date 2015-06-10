package ch08Exercise;

/**
 * 4.2
 * 设计一个简单的学生信息管理系统。每个学生的信息包括学号、姓名、性别、班级和电话等。采用二叉排序树的结构实现以下功能：
 *   ⑴ 创建学生的信息表；
 *   ⑵ 按照学号或姓名查找学生信息。
 * @author dux
 */
import ch07.*;
import ch08.BSTree;
import ch08.StudentType;

public class Exercise8_4_2 {

    public static void main(String args[]) {
        BSTree bstree = new BSTree();   //
        String[][] item={{"小张","男","计科081","13112345671"},
                         {"小李","女","计科082","13212345672"},
                         {"小王","男","计科081","13312345673"},};
        int[] k = {1002, 1001, 1003};  //关键字数组
        KeyType[] key = new KeyType[k.length];          //关键字数组
        StudentType[] elem = new StudentType[k.length]; //记录数据数组
        System.out.println("原序列： ");
        for (int i = 0; i < k.length; i++) {
            key[i] = new KeyType(k[i]);            //创建关键字对象
            elem[i] = new StudentType(item[i]);    //创建记录数据对象
            if (bstree.insertBST(key[i], elem[i])) { //若插入对象成功
                System.out.print("[" + key[i] + "," + elem[i] + "]");
            }
        }
        System.out.println("\n中序遍历二叉排序树：  ");
        bstree.inOrderTraverse(bstree.getRoot());
        System.out.println();
        KeyType keyvalue = new KeyType();
        keyvalue.setKey(1002);
        RecordNode found = (RecordNode) bstree.searchBST(keyvalue);
        if (found != null) {
            System.out.println("按学号查找：" + keyvalue + ",成功！ 对应学生为:" + found.getElement());
        } else {
            System.out.println("按学号查找：" + keyvalue + ",失败!");
        }

        keyvalue.setKey(1005);
        found = (RecordNode) bstree.searchBST(keyvalue);
        if (found != null) {
            System.out.println("按学号查找：" + keyvalue + ",成功！ 对应学生为:" + found.getElement());
        } else {
            System.out.println("按学号查找：" + keyvalue + ",失败!");
        }

    }
}

//测试结果：
/*
原序列：
[1002,小张,男,计科081,13112345671][1001,小李,女,计科082,13212345672][1003,小王,男,计科081,13312345673]
中序遍历二叉排序树：
[1001,小李,女,计科082,13212345672][1002,小张,男,计科081,13112345671][1003,小王,男,计科081,13312345673]
按学号查找：1002,成功！ 对应学生为:小张,男,计科081,13112345671
按学号查找：1005,失败!
 */