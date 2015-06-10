package ch01Exercise;
/**
 * 2．设计一个复数类，要求： (1) 在复数内部用双精度浮点数定义其实部和虚部。 (2)
 * 实现3个构造函数：第1个构造函数没有参数；第2个构造函数将双精度浮点数赋给复数的实部，虚部为0；第3个构造函数将两个双精度浮点数分别赋给复数的实部和虚部。
 * (3) 编写获取和修改复数的实部和虚部的成员函数。 (4) 编写实现复数的减法、乘法运算的成员函数。 (5)
 * 设计一个测试主函数，使其实际运行验证类中各成员函数的正确性。
 * 
 * @author zou
 * @see ch01.Complex
 * 
 */
//复数类
class Complex  {
	    private double real;// 实部

	    private double imag; // 虚部

	    //无参构造函数
	    public  Complex() {
		    this(0, 0);
	    }

	    //带一个参数的构造函数
	    public Complex(double real) {
	    	this(real, 0);
	    }

	   //带两个参数的构造函数
	    public Complex(double real, double imag) {
	    	this.real = real;
	    	this.imag = imag;
	    }

	
	    public double getReal() {
		    return real;
	    }

	
	    public void setReal(double real) {
		    this.real = real;

	    }

		public double getImag() {
		    return imag;
	    }

		public void setImag(double imag) {
		    this.imag = imag;

	    }

		public void add(Complex Z) {
		    if (Z != null) {
			    real += Z.getReal();
			    imag += Z.getImag();
		   }
	    }

	    //计算与另一复数的差,其中Z是减数
	    public void minus(Complex Z) {
		    if (Z != null) {
		    	real -= Z.getReal();
			    imag -= Z.getImag();
		    }
	    }

	    // 计算与另一复数的乘积,其中 Z是乘数
		public void multiply(Complex Z) {
		    if (Z != null) {
			    double temp = (real * Z.getReal() - imag * Z.getImag());
			    imag = (real * Z.getImag() + imag * Z.getReal());
			    real = temp;
		    }
	    }
    }
//测试类
public class Exercise1_3_2 {

	public static void main(String[] args) {
		Complex c1 = new Complex(2, 3);
		System.out.println("修改前c1的实部为：" + c1.getReal() + " 虚部为：" + c1.getImag());
		c1.setReal(1);
		c1.setImag(2);
		System.out.println("修改后c1的实部为：" + c1.getReal() + " 虚部为：" + c1.getImag());

		Complex c2 = new Complex(4, 5);
		c1.add(c2);
		System.out.println("执行加法运算后c1的实部为：" + c1.getReal() + " 虚部为："
				+ c1.getImag());
		
		c1.minus(c2);
		System.out.println("执行减法运算后c1的实部为：" + c1.getReal() + " 虚部为："
				+ c1.getImag());
		
		c1.multiply(c2);
		System.out.println("执行乘法运算后c1的实部为：" + c1.getReal() + " 虚部为："
				+ c1.getImag());

	}
}

// 调试结果：
//修改前c1的实部为：2.0 虚部为：3.0
// 修改后c1的实部为：1.0 虚部为：2.0
// 执行加法运算后c1的实部为：5.0 虚部为：7.0
// 执行减法运算后c1的实部为：1.0 虚部为：2.0
// 执行乘法运算后c1的实部为：-6.0 虚部为：13.0
