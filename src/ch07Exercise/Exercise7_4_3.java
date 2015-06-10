package ch07Exercise;

/**
 * 4.3: 编写程序，要求随机生成10000个数,并比较直接插入排序、直接选择排序、冒泡排序、快速排序和堆排序的排序性能。
 *  @author dux
 */
import ch07.*;

public class Exercise7_4_3 {

    static int maxSize = 10000;  //排序关键码个数

    public static void main(String[] args) throws Exception {
        int[] d = new int[maxSize];  //顺序表空间大小
        for (int i = 0; i < maxSize; i++) {
            d[i] = (int) (Math.random() * 100);
        }
        SeqList L;
        L = createList(d);
        System.out.println("直接插入排序所需时间：" + testSortTime(L, 'i') + "毫秒");
        L = createList(d);
        System.out.println("冒泡排序所需时间：" + testSortTime(L, 'b') + "毫秒");
        L = createList(d);
        System.out.println("快速排序所需时间：" + testSortTime(L, 'q') + "毫秒");
        L = createList(d);
        System.out.println("直接选择排序所需时间：" + testSortTime(L, 's') + "毫秒");
        L = createList(d);
        System.out.println("堆排序所需时间：" + testSortTime(L, 'h') + "毫秒");
    }

    private static SeqList createList(int[] d) throws Exception {
        SeqList L = new SeqList(maxSize);   //建立顺序表
        for (int i = 0; i < d.length; i++) {
            RecordNode r = new RecordNode(d[i]);
            L.insert(L.length(), r);
        }
        return L;
    }

    public static long testSortTime(SeqList L, char sortmethod) {

        long startTime, endTime, testTime;
        startTime = System.currentTimeMillis();
        switch (sortmethod) {
            case 'i':
                L.insertSort();
                break;
            case 's':
                L.selectSort();
                break;
            case 'b':
                L.bubbleSort();
                break;
            case 'q':
                L.quickSort();
                break;
            case 'h':
                L.heapSort();
                break;
        }
        endTime = System.currentTimeMillis();
        testTime = endTime - startTime;
        return testTime;
    }
}
//测试结果：
/*
直接插入排序所需时间：562毫秒
冒泡排序所需时间：1469毫秒
快速排序所需时间：16毫秒
直接选择排序所需时间：812毫秒
堆排序所需时间：16毫秒
 */
