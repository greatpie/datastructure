package ch07Exercise;

/**
 *
 * 3.3 ：试设计算法，实现双向冒泡排序(即相邻两遍向相反方向冒泡)。
 * @author dux
 */
public class Exercise7_3_3 {

    public static int[] random(int n) { //产生随机数
        if (n > 0) {
            int table[] = new int[n];
            for (int i = 0; i < n; i++) {
                table[i] = (int) (Math.random() * 100);//产生一个0~100之间的随机数
            }
            return table;
        }
        return null;
    }

    public static void print(int[] table)//输出数组元素
    {
        if (table.length > 0) {
            for (int i = 0; i < table.length; i++) {
                System.out.print(table[i] + " ");
            }
            System.out.println();
        }
    }

    public static void dbubblesort(int[] table) {
        //双向冒泡排序
        int high = table.length;
        int left = 1;
        int right = high - 1;
        int t = 0;
        do {
            //正向部分
            for (int i = right; i >= left; i--) {
                if (table[i] < table[i - 1]) {
                    int temp = table[i];
                    table[i] = table[i - 1];
                    table[i - 1] = temp;
                    t = i;
                }
            }
            left = t + 1;
            //反向部分
            for (int i = left; i < right + 1; i++) {
                if (table[i] < table[i - 1]) {
                    int temp = table[i];
                    table[i] = table[i - 1];
                    table[i - 1] = temp;
                    t = i;
                }
            }
            right = t - 1;
        } while (left <= right);
    }

    public static void main(String[] args) {
        int[] table = random(8);
        System.out.println("排序前: ");
        print(table);
        dbubblesort(table);
        System.out.println("排序后: ");
        print(table);
    }
}

//测试结果：
/*
排序前:
53 17 36 67 23 75 54 82
排序后:
17 23 36 53 54 67 75 82 
 */