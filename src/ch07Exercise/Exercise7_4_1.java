package ch07Exercise;

/**
 * 4.1:编写程序，对直接插入排序、希尔排序、冒泡排序、快速排序、直接选择排序、堆排序和归并排序进行测试。
 *  @author dux
 */
import ch07.*;
import java.util.Scanner;

public class Exercise7_4_1 {

    public static void main(String[] args) throws Exception {

        int[] d = {52, 39, 67, 95, 70, 8, 25, 52};
        int[] dlta = {5, 3, 1};   //希尔排序增量数组
        int maxSize = 20;                  //顺序表空间大小
        SeqList L = new SeqList(maxSize); //建立顺序表
        for (int i = 0; i < d.length; i++) {
            RecordNode r = new RecordNode(d[i]);
            L.insert(L.length(), r);
        }

        System.out.println("排序前：");
        L.display();
        System.out.println("请选择排序方法：");
        System.out.println("1-直接插入排序");
        System.out.println("2-希尔排序");
        System.out.println("3-冒泡排序");
        System.out.println("4-快速排序");
        System.out.println("5-直接选择排序");
        System.out.println("6-堆排序");
        System.out.println("7-归并排序");
        Scanner s = new Scanner(System.in);
        int xz = s.nextInt();
        switch (xz) {
            case 1:
                L.insertSort();
                break;            //直接插入排序
            case 2:
                L.shellSort(dlta);
                break;         //希尔排序
            case 3:
                L.bubbleSort();
                break;                 //冒泡排序
            case 4:
                L.quickSort();
                break;              //快速排序
            case 5:
                L.selectSort();
                break;               //直接选择排序
            case 6:
                L.heapSort();       //堆排序
                break;
            case 7:
                L.mergeSort();   //归并排序
                break;
        }
        System.out.println("排序后：");
        L.display();
    }
}

//测试结果：
/*
排序前：
 52 39 67 95 70 8 25 52
请选择排序方法：
1-直接插入排序
2-希尔排序
3-冒泡排序
4-快速排序
5-直接选择排序
6-堆排序
7-归并排序
1
排序后：
 8 25 39 52 52 67 70 95
 */