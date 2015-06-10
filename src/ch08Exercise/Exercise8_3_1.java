package ch08Exercise;
/**
 * 3.1: 基于SeqList类，设计带监视哨的顺序查找算法，要求把监视哨设置在n号单元。
 * 若查找成功返回其下标，否则返回-1
 * @author dux
 */

import ch07.*;
import java.util.Scanner;

public class Exercise8_3_1 extends SeqList {

    static Exercise8_3_1 ST = null;

    public Exercise8_3_1(int maxSize) {
        super(maxSize);
    }

    public int seqSearchWithGuard(Comparable key) {
        int i = length() - 1;
        getRecord()[i].setKey(key);    //哨兵设置在第n号单元
        i = 0;
        while ((getRecord()[i].getKey()).compareTo(key) != 0) {
            i++;
        }
        if (i < length() - 1) {
            return i;
        } else {
            return -1;
        }
    }

    public static void createSearchList() throws Exception {
        int maxSize = 20;  //查找表预分配空间的大小
        ST = new Exercise8_3_1(maxSize);    //创建查找表对象
        int curlen;       //表的实际长度
        System.out.println("请输入表的长度:");
        Scanner sc = new Scanner(System.in);
        curlen = sc.nextInt();
        KeyType[] k = new KeyType[curlen + 1];  //多申请一个单元
        System.out.println("请输入关键码序列:");
        for (int i = 0; i < curlen; i++) {  //输入关键字序列
            k[i] = new KeyType(sc.nextInt());
        }
        for (int i = 0; i < curlen + 1; i++) {  //记录顺序表
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
        System.out.println("seqSearchWithGuard(" + key1.getKey() + ")=" + ST.seqSearchWithGuard(key1));
        System.out.println("seqSearchWithGuard(" + key2.getKey() + ")=" + ST.seqSearchWithGuard(key2));
     }
}

//测试结果：
/*
请输入表的长度:
5
请输入关键码序列:
23 12 45 33 67
请输入2个关键码:
45 32
seqSearchWithGuard(45)=2
seqSearchWithGuard(32)=-1
 */