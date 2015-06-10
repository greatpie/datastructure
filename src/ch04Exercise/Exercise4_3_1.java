package ch04Exercise;

import ch04.SeqString;

/**
 * 3.1：编写基于SeqString类的成员函数count(),统计当前字符串中的单词个数。
 * @author dux
 */
public class Exercise4_3_1 extends SeqString {

    public Exercise4_3_1(String str) {
        super(str);
    }

    public int count() {
        int wordcount = 0;  //单词个数
        char currChar, preChar;
        for (int i = 1; i < this.length(); i++) {
            currChar = this.charAt(i);   //当前字符
            preChar = this.charAt(i - 1);  //前一个字符
            if (((int) (currChar) < 65 || (int) (currChar) > 122 //当前字符不是字母
                    || ((int) (preChar) > 90 && (int) (preChar) < 97))
                    && (((int) (preChar) >= 65 && (int) (preChar) <= 90) //当前字符的前一个字符是字母
                    || ((int) (preChar) >= 97 && (int) (preChar) <= 122))) {
                wordcount++;
            }
        }
        return wordcount;
    }

    public static void main(String[] args) {
        String str1 = "too be or not too be,that is the question.";
        Exercise4_3_1 sstr = new Exercise4_3_1(str1);
        System.out.println("字符串 " + str1 + "共有单词数为：" + sstr.count());
    }
}

//测试结果：
//字符串 too be or not too be,that is the question.共有单词数为：10