package ch01;

/**
 * 复数类，实现了获取和修改复数实部和虚部的成员函数，同时实现了复数的加法、减法、乘法运算的成员函数
 * 
 * @author zou
 * 
 * @see ch01.IComplex
 */

public class Complex implements IComplex {
	private double real;// 实部

	private double imag; // 虚部

	/**
	 * 无参构造函数
	 */
	public Complex() {
		this(0, 0);
	}

	/**
	 * @param real
	 *            复数实部
	 */
	public Complex(double real) {
		this(real, 0);
	}

	/**
	 * @param real
	 *            复数实部
	 * @param imag
	 *            复数虚部
	 */
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch01.IComplex#getReal()
	 */
	public double getReal() {
		return real;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch01.IComplex#setReal(double)
	 */
	public void setReal(double real) {
		this.real = real;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch01.IComplex#getImag()
	 */
	public double getImag() {
		return imag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch01.IComplex#setImag(double)
	 */
	public void setImag(double imag) {
		this.imag = imag;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch01.IComplex#add(ch01.IComplex)
	 */
	public void add(IComplex Z) {
		if (Z != null) {
			real += Z.getReal();
			imag += Z.getImag();
		}
	}

	/**
	 * 计算与另一复数的差
	 * 
	 * @param Z
	 *            减数
	 */
	public void minus(IComplex Z) {
		if (Z != null) {
			real -= Z.getReal();
			imag -= Z.getImag();
		}
	}

	/**
	 * 计算与另一复数的乘积
	 * 
	 * @param Z
	 *            乘数
	 */
	public void multiply(IComplex Z) {
		if (Z != null) {
			double temp = (real * Z.getReal() - imag * Z.getImag());
			imag = (real * Z.getImag() + imag * Z.getReal());
			real = temp;
		}
	}
}
