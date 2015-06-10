package ch01;

/**
 * 复数接口，定义了获取和修改复数实部和虚部的函数，同时还定义了复数的加法运算的函数
 * 
 * @author zou
 * 
 */

public interface IComplex {

	/**
	 * @return 复数实部
	 */
	double getReal();

	/**
	 * 修改复数实部
	 * 
	 * @param real
	 */
	void setReal(double real);

	/**
	 * @return 虚数虚部
	 */
	double getImag();

	/**
	 * 修改复数虚部
	 * 
	 * @param imag
	 */
	void setImag(double imag);

	/**
	 * 计算与另一复数的和
	 * 
	 * @param Z
	 *            另一复数
	 */
	void add(IComplex Z);
}
