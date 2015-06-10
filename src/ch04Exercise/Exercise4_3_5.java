package ch04Exercise;

import ch04.SeqString;

/**
 * 3.5：编写基于SeqString类的成员函数stringcount(str)。
 * 要求统计子串str在当前对象串中出现的次数，若不出现则返回0。
 * @author dux
 */
public class Exercise4_3_5 extends SeqString {
     SeqString curstr;

    public Exercise4_3_5(String str) {
        super(str);
        this.curstr=new SeqString(str);
    }
    
    public int stringCount(SeqString str) {
        SeqString source = this.curstr;
        int count = 0, begin = 0;
        int index;
        while ((index = source.indexOf(str, begin)) != -1) {
            count++;
            begin = index + str.length();
        }
        return count;
    }

    public static void main(String[] args) {
        String str1 = "too be or not too be,that is the question.";
     
        Exercise4_3_5 sstr = new Exercise4_3_5(str1);
        System.out.println("原字符串为 "+str1);
        String instr="too";
        System.out.println("字符串中包含"+instr+"的个数为：" + sstr.stringCount(new SeqString(instr)));
    }
}

//测试结果：
//原字符串为 too be or not too be,that is the question.
//字符串中包含too的个数为：2