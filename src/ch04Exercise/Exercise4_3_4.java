package ch04Exercise;

import ch04.SeqString;

/**
 * 3.4：编写基于SeqString类的成员函数deleteallchar(ch)，
 * 要求从当前对象串中删除其值等于ch的所有字符。
 * @author dux
 */
public class Exercise4_3_4 extends SeqString {

    public Exercise4_3_4(String str) {
        super(str);      
    }

    public SeqString deleteAllChar(char ch) {
        SeqString s1 = new SeqString(String.valueOf(ch));
        if (s1 == null) {
            return null;
        }
        SeqString ss = new SeqString("");  //产生空串
        SeqString source = this;        //当前串赋值到sourse
        int index = -1;
        while ((index = source.indexOf(s1, 0)) != -1) {
            ss.concat(source.substring(0, index));            //串连接
            source = (SeqString) source.substring(index + 1);  //取子串
        }
        ss.concat(source);  //串连接
        return ss;
    }

    public static void main(String[] args) {
        String str1 = "too be or not too be,that is the question.";
        Exercise4_3_4 sstr = new Exercise4_3_4(str1);
        System.out.println("原字符串为 " + str1);
        char ch = 'o';
        SeqString s=sstr.deleteAllChar(ch);
        System.out.println("删除字符" + String.valueOf(ch) + "后的字符串为 " + sstr.deleteAllChar(ch));
    }
}
//测试结果：
//原字符串为 too be or not too be,that is the question.
//删除字符o后的字符串为 t be r nt t be,that is the questin.
