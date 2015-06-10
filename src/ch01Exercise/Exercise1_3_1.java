package ch01Exercise;

/**
 * 1．编写一个实现将整型数组中的数据元素按值递增的顺序进行排序的Java程序。
 * 
 * @author zou
 * 
 */
public class Exercise1_3_1 {
	/**
	 * 
	 * @param a
	 *            无序的整数数组
	 * @return 按值递增的顺序排序的数组
	 */
	public int[] bubbleSort(int[] a) {
		int n = a.length;
		boolean isExchange = true; // 交换标志
		for (int i = 0; i < n - 1&&isExchange; i++) { // 最多做n-1趟排序
			isExchange = false;
			for (int j = 0; j < n - i - 1; j++) {// 对当前无序区进行排序
				if (a[j] > a[j + 1]) {// 交换数据元素
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					isExchange = true; // 发生了交换，故将交换标志置为真
				}
			}
			if (!isExchange)
				break; // 本趟排序未发生交换，提前终止算法
		}
		return a;
	}

	public static void main(String[] args) {
		int[] values = { 49, 38, 65, 97, 76, 13, 27, 49 };
		System.out.println("排序前数组中数据元素：49 38 65 97 76 13 27 49");
		System.out.print("排序后数组中数据元素：");

		Exercise1_3_1 e = new Exercise1_3_1();
		values = e.bubbleSort(values);
		for (int i = 0; i < values.length; i++)
			System.out.print(values[i] + " ");
	}
}

//调试结果：
//排序前数组中数据元素：49 38 65 97 76 13 27 49
//排序后数组中数据元素：13 27 38 49 49 65 76 97 