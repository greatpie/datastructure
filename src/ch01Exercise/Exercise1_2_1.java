package ch01Exercise;

import java.text.DecimalFormat;

/**
 * 1．有一个包括100 个数据元素的数组，每个数据元素的值都是实数，试编写一个求最大数据元素的值及其下标的算法，并分析算法的时间复杂度。
 * 
 * @author zou
 * 
 */
public class Exercise1_2_1 {

     void  max(double[] a) {
        double max = a[0];// 初始化最大值为数组中的第一个元素
	    int index = 0;   //
        for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
				index = i;
			}
        }
		System.out.println("\n数组中最大的实数为：" + max + "\n其在数组中的下标为：" + index);// 输出结果
        
    }
    public static void main(String[] args) {
		double[] values = new double[100];
		DecimalFormat df = new DecimalFormat("#0.0"); // 保留一位小数
		for (int i = 0; i < 100; i++){
			values[i] = Double.valueOf(df.format(Math.random() * 100));// 在0-100之间随机初始化100个实数
            if (i != 0 && i % 10 == 0)
				System.out.println();// 换行
			System.out.print(values[i] + " ");
        }
        Exercise1_2_1 d = new Exercise1_2_1();
        d.max(values);
	  }
}

// 调试结果：
// 数组中的各个数据元素为：
// 79.7 0.9 86.4 68.9 50.4 85.2 86.5 88.4 12.9 97.0
// 7.1 43.0 54.7 67.5 27.0 68.5 20.6 5.3 7.4 37.8
// 90.8 40.1 40.0 62.0 7.6 0.7 15.2 72.7 64.9 84.7
// 71.1 70.0 84.6 87.0 43.7 48.7 43.2 15.8 82.6 36.1
// 80.6 39.4 11.5 7.8 16.0 75.6 13.6 76.7 22.2 56.2
// 94.2 89.1 58.7 75.1 27.9 96.7 45.3 51.6 27.9 18.0
// 66.6 28.0 85.6 43.8 29.9 46.3 14.2 93.7 69.5 43.4
// 98.9 75.5 75.4 37.1 96.8 60.8 52.4 74.3 54.4 38.8
// 56.1 53.5 8.4 79.0 37.3 39.0 15.0 89.2 23.4 30.4
// 9.7 28.4 4.0 61.0 32.7 98.2 45.9 56.5 67.8 13.4
// 数组中最大的实数为：98.9
// 其在数组中的下标为：70

