//字符串抽象数据类型的接口定义
package ch04;

public interface IString {

    public void clear();          //将一个已经存在的串置成空串

    public boolean isEmpty();    //判断当前串是否为空，为空则返回true，否则返回false

    public int length();         //返回字符串的长度

    public char charAt(int index);   //返回串中序号为index的字符

    public IString substring(int begin, int end); //返回串中字符序号从begin至end-1的子串

    public IString insert(int offset, IString str);  //在当前串的第offset个字符之前插入串str

    public IString delete(int begin, int end);   //删除当前串中从序号begin开始到序号end-1为止的子串

    public IString concat(IString str);  //添加指定串str到当前串尾

    //将当前串与目标串str进行比较，若当前串大于str，则返回一个正整数，若当前串等于str，则返回0，若当前串小于str，则返回一个负整数。
    public int compareTo(IString str);
    //若当前串中存在和str相同的子串，则返回模式串str在主串中从第start字符开始的第一次出现位置，否则返回-1
    public int indexOf(IString str,int start);
}
