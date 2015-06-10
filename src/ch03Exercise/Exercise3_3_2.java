package ch03Exercise;

import ch03.LinkStack;

/**
 * 
 * 2.编写一个函数判断一个字符序列是否为回文序列，所谓回文序列就是正读与反读都相同的字符序列，例如：abba和abdba均是回文序列。要求只使用栈来实现。
 * 
 * @author zou
 * 
 */
public class Exercise3_3_2 {

	/**
	 * 判断字符序列是否为回文序列
	 * 
	 * @param str
	 *            字符序列
	 * @return 若是回文序列返回true，否则返回false
	 */
	public boolean isPalindSeq(String str) {
		LinkStack S = new LinkStack();
		int i = 0;
		for (; i < str.length(); i++)
			S.push(str.charAt(i));

		for (i = 0; i < str.length(); i++) {
			char c = ((Character) S.pop()).charValue();
			if (c != str.charAt(i))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String str1 = "abdba";
		String str2 = "abcde";
		Exercise3_3_2 e = new Exercise3_3_2();
		if (e.isPalindSeq(str1))
			System.out.println("字符序列abdba是回文序列");
		else
			System.out.println("字符序列abdba不是回文序列");

		if (e.isPalindSeq(str2))
			System.out.println("字符序列abdba是回文序列");
		else
			System.out.println("字符序列abdba不是回文序列");
	}
}

// 调试结果：
// 字符序列abdba是回文序列
// 字符序列abdba不是回文序列
