package ch07Exercise;

import ch07.RecordNode;
import ch07.SeqList;

/**
 * 4.2:编写程序，对带监视哨的直接插入排序进行测试。
 *  @author dux
 */
public class Exercise7_4_2 extends SeqList {

    public Exercise7_4_2(int maxSize) {
        super(maxSize);
    }

    public void display() {    //输出数组元素
        for (int i = 1; i < length(); i++) {
            System.out.print(" " + getRecord()[i].getKey().toString());
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        int[] d = {52, 39, 67, 95, 70, 8, 25, 52};

        int maxSize = 20;                    //顺序表空间大小
        SeqList L = new Exercise7_4_2(maxSize);    //建立顺序表
        
        RecordNode r = new RecordNode(0);
        L.insert(L.length(), r);
        for (int i = 0; i < d.length; i++) {
            r = new RecordNode(d[i]);
            L.insert(L.length(), r);
        }

        System.out.println("排序前：");
        L.display();
        L.insertSortWithGuard();
        System.out.println("排序后：");
        L.display();
    }
}

//测试结果：
/*
排序前：
 52 39 67 95 70 8 25 52
带监视哨的直接插入排序
排序后：
 8 25 39 52 52 67 70 95
 */