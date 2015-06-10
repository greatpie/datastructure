package ch02;

/**
 * 
 * 多项式的结点,作为链表(LNode)的数据元素(data)
 * 
 */
public class PolynNode {
	private double coef; // 系数

	private int expn; // 指数

	public PolynNode(double coef, int expn) { // 构造函数
		this.coef = coef;
		this.expn = expn;
	}

	public double getCoef() {
		return coef;
	}

	public int getExpn() {
		return expn;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}

	public void setExpn(int expn) {
		this.expn = expn;
	}
}
