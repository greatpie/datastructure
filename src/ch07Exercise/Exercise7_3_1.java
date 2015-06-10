package ch07Exercise;

import ch02.*;
import java.util.Scanner;

/**
 *
 * 3.1 ：试设计算法，用插入排序方法对单链表进行排序。
 * @author dux
 */
public class Exercise7_3_1 {

    public static void insertSort(LinkList L) {
        Node p, q, r, u;
        p = L.getHead().getNext();
        L.getHead().setNext(null);  //置空表，然后将原链表结点逐个插入到有序表中
        while (p != null) {          //当链表尚未到尾，p为工作指针
            r = L.getHead();
            q = L.getHead().getNext();
            while (q != null && (Integer.parseInt((String) q.getData())) <= (Integer.parseInt((String) p.getData()))) {  //查P结点在链表中的插入位置，这时q是工作指针
                r = q;
                q = q.getNext();
            }
            u = p.getNext();
            p.setNext(r.getNext());
            r.setNext(p);
            p = u; //将P结点链入链表中，r是q的前驱，u是下一个待插入结点的指针
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待排序的结点数：");
        int k = sc.nextInt();
        System.out.println("请输入单链表中的" + k + "个结点值：");
        LinkList L = new LinkList(k, true);// 从表头到表尾顺序建立一个单链表
        System.out.println("排序前单链表中各个结点值：");
        L.display();
        insertSort(L);
        System.out.println("排序后单链表中各个结点值为：");// 输出
        L.display();
    }
}
//测试结果：
/*
 * 请输入待排序的结点数：
5
请输入单链表中的5个结点值：
23 12 33 56 43
排序前单链表中各个结点值：
23 12 33 56 43
排序后单链表中各个结点值为：
12 23 33 43 56
 */
