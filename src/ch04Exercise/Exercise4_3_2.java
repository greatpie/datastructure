package ch04Exercise;

import ch04.SeqString;

/**
 * 3.2：编写基于SeqString类的成员函数replace(begin,s1,s2)。要求在当前对象串中，
 * 从下标begin开始，将所有的s1子串替换为s2串。
 * @author dux
 */
public class Exercise4_3_2 extends SeqString {

    public Exercise4_3_2(String str) {
        super(str);
    }

    /*
     * @param begin int 开始位置
     * @param s1 String 原始字符串
     * @param s2 String 目标字符串
     * @return SqString 替换后的字符串
     */
    public SeqString replace(int begin, SeqString s1, SeqString s2) {
        if (s1 == null || s2 == null) {
            return null;
        }
        SeqString ss = new SeqString("");  //产生空串
        SeqString source = this;
        int index = -1;
        while ((index = source.indexOf(s1, begin)) != -1) {
            ss.concat(source.substring(0, index));   //串连接
            ss.concat(s2);
            source = (SeqString) source.substring(index + s1.length()); //取子串
        }
        ss.concat(source);  //串连接
        return ss;
    }

    public static void main(String[] args) {
        String str1 = "too be or not too be,that is the question.";
        Exercise4_3_2 sstr = new Exercise4_3_2(str1);
        System.out.println("原字符串为 " + str1);
        String s1 = "too", s2 = "to";
        System.out.println("把" + s1 + "替换为" + s2 + "后的字符串为" + sstr.replace(0, new SeqString(s1), new SeqString(s2)));
    }
}
//测试结果：
//原字符串为 too be or not too be,that is the question.
//把too替换为to后的字符串为to be or not to be,that is the question.
