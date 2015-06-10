package ch01Exercise;

/**
 * 2．试编写一个求一元多项式的值Pn(x0)的算法，并确定算法中每一条语句的执行次数和整个算法的时间复杂度（注意选择你认为较好的输入和输出方法）。输入是ai(i=0,1,2,…,n)，x0和n，输出为Pn(x0)。
 * 
 * @author zou
 * 
 */
public class Exercise1_2_2 {

	/**
	 * 
	 * @param a
	 *            多项式中系数数组
	 * @param x
	 *            多项式中x的值
	 * @return 多项式的值
	 */
	public double getPolynomialResult(double[] a, double x) {
		double result = 0;
		double powX = 1;// 临时变量，用于减少计算x幂的计算次数
		for (int i = 0; i < a.length; i++) {
			result += a[i] * powX;
			powX *= x;
		}
		return result;
	}

	public static void main(String[] args) {
		double x = 2;
		double[] coefs = { 1, 2, 4, 5, 7, 9, 10, 11, };// 初始化多项式的系数

		Exercise1_2_2 e = new Exercise1_2_2();
		System.out.println("多项式的值为：" + e.getPolynomialResult(coefs, x));

	}
}

// 调试结果：
// 多项式的值为：2509.0
