package ch08Exercise;
/**
 * 3.2: 基于SeqList类，设计一个递归算法，实现二分查找,
 * 数组元素已按升序排列，若查找成功返回元素下标，否则返回-1.
 * @author dux
 */

import ch07.*;
import java.util.Scanner;

public class Exercise8_3_2 extends SeqList {

    static Exercise8_3_2 ST = null;

    public Exercise8_3_2() {
    }

    public Exercise8_3_2(int maxSize) {
        super(maxSize);
    }

    public int binarySearchRecursively(int low, int high, Comparable key) {
        int mid, result;
        if (low <= high) {
            mid = (low + high) / 2;   //中间位置，当前比较元素位置
            result = getRecord()[mid].getKey().compareTo(key);
            if (result > 0) {
                return binarySearchRecursively(low, mid - 1, key);                                //查找成功
            } else if (result < 0) {
                return binarySearchRecursively(mid + 1, high, key);
            } else {
                return mid;
            }
        }
        return -1;  //查找不成功
    }

    public static void createSearchList() throws Exception {
        int maxSize = 20;  //查找表预分配空间的大小
        ST = new Exercise8_3_2(maxSize);    //创建查找表对象
        int curlen;       //表的实际长度
        System.out.println("请输入表的长度:");
        Scanner sc = new Scanner(System.in);
        curlen = sc.nextInt();
        KeyType[] k = new KeyType[curlen];
        System.out.println("请输入从小到大排序的关键码序列:");
        for (int i = 0; i < curlen; i++) {  //输入关键字序列
            k[i] = new KeyType(sc.nextInt());
        }
        for (int i = 0; i < curlen; i++) {  //记录顺序表
            RecordNode r = new RecordNode(k[i]);
            ST.insert(ST.length(), r);
        }
    }

    public static void main(String[] args) throws Exception {

        createSearchList();   //创建查找表
        System.out.println("请输入2个关键码:");  //提示输入待查找的关键字
        Scanner sc = new Scanner(System.in); //输入待查找关键字
        KeyType key1 = new KeyType(sc.nextInt());
        KeyType key2 = new KeyType(sc.nextInt());
        System.out.println("");
        System.out.println("binarySearchRecursively(" + key1.getKey() + ")=" + ST.binarySearchRecursively(0, ST.length() - 1, key1));
        System.out.println("binarySearchRecursively(" + key2.getKey() + ")=" + ST.binarySearchRecursively(0, ST.length() - 1, key2));

    }
}

//测试结果：
/*
请输入表的长度:
7
请输入从小到大排序的关键码序列:
12 34 56 78 90 110 120
请输入2个关键码:
90 65

binarySearchRecursively(90)=4
binarySearchRecursively(65)=-1
 */