package ch04Exercise;

import ch04.SeqString;

/**
 * 3.3：编写基于SeqString类的成员函数reverse()。要求将当前对象中的字符反序存放。
 * @author dux
 */
public class Exercise4_3_3 extends SeqString {

    public Exercise4_3_3(String str) {
        super(str);
    }

    public SeqString reverse() {

        for (int i = 0, j = this.length() - 1; i < j; i++, j--) {
            char temp = this.charAt(i);
            setCharAt(i, this.charAt(j));
            setCharAt(j, temp);
        }
        return this;
    }

    public static void main(String[] args) {
        String str1 = "too be or not too be,that is the question.";
        Exercise4_3_3 sstr = new Exercise4_3_3(str1);
        System.out.println("原字符串为 " + str1);
        System.out.println("反转后的字符串为 " + sstr.reverse());
    }
}
//测试结果：
//原字符串为 too be or not too be,that is the question.
//反转后的字符串为 .noitseuq eht si taht,eb oot ton ro eb oot
