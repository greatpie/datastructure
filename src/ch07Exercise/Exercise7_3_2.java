package ch07Exercise;

import ch02.*;
import java.util.Scanner;

/**
 *
 * 3.2 ：设计算法，用选择排序方法对单链表进行排序。
 * @author dux
 */
public class Exercise7_3_2 {

    //单链表选择排序算法
    public static void selectSort(LinkList L) {
        //p为当前最小,r为此过程中最小,q为当前扫描接点
        Node p, r, q;
        Node newNode = new Node();
        newNode.setNext(L.getHead());
        L.setHead(newNode);
        //制造一个最前面的节点newNode，解决第一个节点的没有前续节点需要单独语句的问题。
        p = L.getHead();
        while (p.getNext().getNext() != null) {
            r = p.getNext();
            q = p.getNext().getNext();
            while (q.getNext() != null) {
                if (Integer.parseInt((String) q.getNext().getData()) <= (Integer.parseInt((String) r.getNext().getData()))) {
                    r = q;
                }
                q = q.getNext();
            }
            if (r != p) {  //交换p与r
                Node swap = r.getNext();
                r.setNext(r.getNext().getNext());  //r的next指向其后继的后继
                swap.setNext(p.getNext());
                p.setNext(swap);  //p的后继为swap             
            }
            p = p.getNext();
        }//while    
        p.setNext(null);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待排序的结点数：");
        int k = sc.nextInt();
        System.out.println("请输入单链表中的" + k + "个结点值：");
        LinkList L = new LinkList(k, true);// 从表头到表尾顺序建立一个表长为5的单链表

        System.out.println("排序前单链表中各个结点值：");
        L.display();
        selectSort(L);
        System.out.println("排序后单链表中各个结点值为：");// 输出
        L.display();
    }
}

//测试结果：
/*
请输入待排序的结点数：
5
请输入单链表中的5个结点值：
56 23 12 65 43
排序前单链表中各个结点值：
56 23 12 65 43
排序后单链表中各个结点值为：
12 23 43 56 65
 */

