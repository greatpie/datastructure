package ch02Exercise;

import ch02.CircleLinkList;
import ch02.Polyn;

/**
 * 7.编写一个多项式类的成员函数，实现将一个用循环链表表示的稀疏多项式分解成两个多项式的操作，并使两个多项式中各自仅含奇次项或偶次项。要求利用原来循环链表中的存储空间构成这两个链表。
 * 
 * @author zou
 * 
 * @see ch02.Polyn 以循环链表为存储结构的多项式
 * 
 */
public class Exercise2_3_7 {

	public static void main(String[] args) throws Exception {
		Polyn polyn = new Polyn();
        double[] coefs = { 1, 3, 8, 9, 10, 16 }; // 系数数组

		int[] expns = { 1, 12, 19, 23, 25, 30 };// 指数数组

		CircleLinkList L = polyn.creatPolyn(coefs, expns);
		System.out.println("分解前多项式为：");
		polyn.display(L);
		CircleLinkList[] polyns = polyn.separatePolyn(L);
		System.out.println("分解后含奇次项的多项式为：");
		polyn.display(polyns[0]);
		System.out.println("分解后含偶次项的多项式为：");
		polyn.display(polyns[1]);
	}
}

// 调试结果：
// 分解前多项式为：
// 系数为： 1.0 指数为： 1
// 系数为： 3.0 指数为： 12
// 系数为： 8.0 指数为： 19
// 系数为： 9.0 指数为： 23
// 系数为： 10.0 指数为： 25
// 系数为： 16.0 指数为： 30
// 分解后含奇次项的多项式为：
// 系数为： 1.0 指数为： 1
// 系数为： 8.0 指数为： 19
// 系数为： 9.0 指数为： 23
// 系数为： 10.0 指数为： 25
// 分解后含偶次项的多项式为：
// 系数为： 3.0 指数为： 12
// 系数为： 16.0 指数为： 30
