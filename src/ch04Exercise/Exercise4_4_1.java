package ch04Exercise;

/**
 *4.1在顺序串类SeqString中增加一个主函数，测试各成员函数的正确性。
 * @author dux
 */
import ch04.SeqString;

public class Exercise4_4_1 extends SeqString{
    public static void main(String args[]) {
        char[] chararray = {'W', 'o', 'r', 'l', 'd'};
        SeqString s1 = new SeqString();           //构造一个空串
        SeqString s2 = new SeqString("Hello");    //以字符串常量构造串对象
        SeqString s3 = new SeqString(chararray);  //以字符数组构造串对象
        System.out.println("串 s1=" + s1 + ", s2=" + s2 + ", s3=" + s3);
        s1.insert(0, s2);
        System.out.println("串s1在第0个字符前插入串s2后,s1=" + s1);
        s1.insert(1, s3);
        System.out.println("串s1在第1个字符前插入串s3后,s1=" + s1);
        s1.delete(1, 4);
        System.out.println("串s1删除第1到第3个字符后,s1=" + s1);
        System.out.println("串s1中从第2到第5个字符组成的子串是：" + s1.substring(2, 6));      
    }
}

//测试结果：
//串 s1=, s2=Hello, s3=World
//串s1在第0个字符前插入串s2后,s1=Hello
//串s1在第1个字符前插入串s3后,s1=HWorldello
//串s1删除第1到第3个字符后,s1=Hldello
//串s1中从第2到第5个字符组成的子串是：dell