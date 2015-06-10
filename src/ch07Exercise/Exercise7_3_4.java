package ch07Exercise;

/**
 *
 * 3.4 ：试设计算法，使用非递归方法实现快速排序。
 * @author dux
 */
public class Exercise7_3_4 {

    public static int[] random(int n) {
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
  
    public static void NonrecursiveQuickSort(int[] ary) {
        if (ary.length < 2) {
            return;
        }
        //数组栈：记录着高位和低位的值
        int[][] stack = new int[2][ary.length];
        //栈顶部位置
        int top = 0;
        //低位，高位，循环变量，基准点
        //将数组的高位和低位位置入栈
        stack[1][top] = ary.length - 1;
        stack[0][top] = 0;
        top++;
        //要是栈顶不空，那么继续
        while (top != 0) {
            //将高位和低位出栈
            //低位：排序开始的位置
            top--;
            int low = stack[0][top];
            //高位：排序结束的位置
            int high = stack[1][top]; //将高位作为基准位置
            //基准位置
            int pivot = high;
            int i = low;
            for (int j = low; j < high; j++) {
               
                if (ary[j] <= ary[pivot]) {
                    int temp = ary[j];
                    ary[j] = ary[i];
                    ary[i] = temp;
                    i++;
                }
            }
            //如果i不是基准位，那么基准位选的就不是最大值
            //而i的前面放的都是比基准位小的值，那么基准位
            //的值应该放到i所在的位置上
            if (i != pivot) {
                int temp = ary[i];
                ary[i] = ary[pivot];
                ary[pivot] = temp;
            }
             if (i - low > 1) {
                //此时不排i的原因是i位置上的元素已经确定了，i前面的都是比i小的，i后面的都是比i大的
                stack[1][top] = i - 1;
                stack[0][top] = low;
                top++;
            }
            //当high-i小于等于1的时候，就不往栈中放了，这就是外层while循环能结束的原因
            //如果从i到高位之间的元素个数多于一个，那么需要再次排序
            if (high - i > 1) {
                //此时不排i的原因是i位置上的元素已经确定了，i前面的都是比i小的，i后面的都是比i大的
                stack[1][top] = high; 
                stack[0][top] = i + 1;
                top++;
            }
        }
    }

    public static void main(String[] args) {
        int[] table = random(8);
        System.out.println("排序前");
        print(table);
        NonrecursiveQuickSort(table);
        System.out.println("排序后");
        print(table);
    }
}

//测试结果：
/*
排序前
18 30 93 59 42 91 20 58
排序后
18 20 30 42 58 59 91 93
 */