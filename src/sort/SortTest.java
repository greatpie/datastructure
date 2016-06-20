package sort;

import java.util.Random;

/**
 * Created by pie on 2016-5-23.
 */
public class SortTest {
    //希尔排序
    public static int[] shellSort(int[] array) {
        int j = 0;
        int temp = 0;
        for (int increment = array.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < array.length; i++) {
                temp = array[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp < array[j - increment]) {
                        array[j] = array[j - increment];
                    } else {
                        break;
                    }
                }
                array[j] = temp;
            }
        }
        return array;
    }

    //冒泡排序
    public static int[] bubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    //堆排序
    public static int[] heapSort(int[] array) {
        buildHeap(array);//构建堆
        int n = array.length;
        int i = 0;
        for (i = n - 1; i >= 1; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }
        return array;
    }

    public static void buildHeap(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, i, n);
    }

    public static void heapify(int[] A, int idx, int max) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int largest = 0;
        if (left < max && A[left] > A[idx])
            largest = left;
        else
            largest = idx;
        if (right < max && A[right] > A[largest])
            largest = right;
        if (largest != idx) {
            swap(A, largest, idx);
            heapify(A, largest, max);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArr(int[] data) {
        String output = "array:";
        for (int each : data) {
            output += String.valueOf(each) + ',';
        }
        System.out.println(output);
    }

    public static int[] createRandomArr(int length) {
        Random rand = new Random();
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            //random in (1,100)
            data[i] = rand.nextInt(100) + 1;
        }
        return data;
    }

    public static void main(String args[]) {
        //shell
        int[] arrShell = SortTest.createRandomArr(20);
        System.out.println("array between sort");
        SortTest.printArr(arrShell);
        SortTest.shellSort(arrShell);
        System.out.println("after sort");
        SortTest.printArr(arrShell);
        //bubble
        int[] arrBubble = SortTest.createRandomArr(20);
        System.out.println("array between sort");
        SortTest.printArr(arrBubble);
        SortTest.bubbleSort(arrBubble);
        System.out.println("after sort");
        SortTest.printArr(arrBubble);

        //heap
        int[] arrHeap = SortTest.createRandomArr(20);
        System.out.println("array between sort");
        SortTest.printArr(arrHeap);
        SortTest.heapSort(arrHeap);
        System.out.println("after sort");
        SortTest.printArr(arrHeap);
    }
}
