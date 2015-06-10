package ch03Exercise;

import java.util.Scanner;

import ch03.IStack;
import ch03.LinkStack;

/**
 * 
 * 4. 设计一个数制转换类。要求： (1) 编写一个将十进制数转换成二进制数的方法。 (2) 设计一个测试程序进行测试，并给出测试结果。
 * 
 * @author zou
 * 
 */
public class Exercise3_4_4 {

	/**
	 * 把十进制数转换成二进制数
	 * 
	 * @param decimal
	 *            十进制数
	 * @return 返回一个存放二进制数的栈，其中二进制数的最高位位于栈顶
	 */
	public LinkStack convertDToB(int decimal) {
		LinkStack S = new LinkStack();
		while (decimal != 0) {
			S.push(decimal % 2);// 二进制位进栈
			decimal /= 2;
		}
		return S;
	}

	public static void main(String[] args) {
		System.out.println("请输入一个十进制数：");
		Scanner sc = new Scanner(System.in);// 构造用于输入的对象
		Exercise3_4_4 e = new Exercise3_4_4();
		int input = sc.nextInt();
		LinkStack S = e.convertDToB(input);// 进行二进制转换
		System.out.println(input + "对应的二进制数位：");
		S.display();
	}
}

// 调试结果：
// 请输入一个十进制数：
// 9
// 9对应的二进制数位：
// 1 0 0 1
