// 顺序串类的实现。
package ch04;

public class SeqString implements IString {

    private char[] strvalue;            //字符数组，存放串值
    private int curlen;                //当前串的长度

    //构造方法1，构造一个空串
    public SeqString() {
        strvalue = new char[0];
        curlen = 0;
    }

    //构造方法2，以字符串常量构造串对象
    public SeqString(String str) {
        if (str != null) {
            char[] tempchararray = str.toCharArray();
            strvalue = tempchararray;
            curlen = tempchararray.length;
        } 
    }

    //构造方法3，以字符数组构造串对象
    public SeqString(char[] value) {
        this.strvalue = new char[value.length];
        for (int i = 0; i < value.length; i++) { //复制数组
            this.strvalue[i] = value[i];
        }
        curlen = value.length;
    }

    //将一个已经存在的串置成空串
    public void clear() {
        this.curlen = 0;
    }

    //判断当前串是否为空，为空则返回true，否则返回false
    public boolean isEmpty() {
        return curlen == 0;
    }

    //返回字符串长度
    public int length() {
        return curlen;    //区别: strvalue.length是数组容量
    }

    //返回字符串中序号为index的字符
    public char charAt(int index) {
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue[index];
    }
    //将字符串中序号为index的字符设置为ch

    public void setCharAt(int index, char ch) {
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        strvalue[index] = ch;
    }

    public void allocate(int newCapacity) //扩充容量，参数指定最小容量
    {
        char[] temp = strvalue;                           //复制数组
        strvalue = new char[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            strvalue[i] = temp[i];
        }
    }

    //返回串中序号从begin至end-1的子串
    public SeqString substring(int begin, int end) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度:" + curlen);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
        }
        if (begin == 0 && end == curlen) {
            return this;
        } else {
            char[] buffer = new char[end - begin];
            for (int i = 0; i < buffer.length; i++) //复制子串
            {
                buffer[i] = this.strvalue[i + begin];
            }
            return new SeqString(buffer);
        }
    }

    //返回串中序号从begin至串尾的子串
    public IString substring(int begin) {
        return substring(begin, strvalue.length);
    }

    //在当前串的第offset个字符之前插入串str，0<=offset<=curlen
    public IString insert(int offset, IString str) {
        if ((offset < 0) || (offset > this.curlen)) {
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        }
        int len = str.length();
        int newCount = this.curlen + len;
        if (newCount > strvalue.length) {
            allocate(newCount);             // 插入空间不足，需扩充容量
        }
        for (int i = this.curlen - 1; i >= offset; i--) {
            strvalue[len + i] = strvalue[i];    //从offset开始向后移动len个字符
        }
        for (int i = 0; i < len; i++) //复制字符串str
        {
            strvalue[offset + i] = str.charAt(i);
        }
        this.curlen = newCount;
        return this;
    }
    //删除从begin到end-1的子串， 0≤begin≤length()-1，1≤end≤length()。

    public IString delete(int begin, int end) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度:" + curlen);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
        }
        for (int i = 0; i < curlen - end; i++) //从end开始至串尾的子串向前移动到从begin开始的位置
        {
            strvalue[begin + i] = strvalue[end + i];
        }
        curlen = curlen - (end - begin);  //当前串长度减去end-begin
        return this;
    }

    //添加指定串str到当前串尾
    public IString concat(IString str) {
        return insert(curlen, str);
    }
    //将字符c连接到到当前串尾

    public IString concat(char c) {
        int newCount = curlen + 1;
        if (newCount > strvalue.length) {
            allocate(newCount);
        }
        strvalue[curlen++] = c;
        return this;
    }

    //比较串
    public int compareTo(IString str) {
        return compareTo((SeqString) str);
    }

    public int compareTo(SeqString str) {  //比较串
        //若当前对象的串值大于str的串值，则函数返回一个正整数
        //若当前对象的串值等于str的串值，则函数返回0
        //若当前对象的串值小于str的串值，则函数返回一个负整数
        int len1 = curlen;
        int len2 = str.curlen;
        int n = Math.min(len1, len2);
        //char s1[] = strvalue;
        //char s2[] = str.strvalue;
        //int k = 0;
        //while (k < n) {
        //    char ch1 = s1[k];
        //    char ch2 = s2[k];
        //    if (ch1 != ch2) {
        //        return ch1 - ch2;  //返回第一个不相等字符的数值差
        //    }
       //     k++;
        //}
        for (int k=0;k<n;k++)
             if (strvalue[k]!=str.strvalue[k])
                 return(strvalue[k]-str.strvalue[k]);

        return len1 - len2;   //返回两个字符串长度的数值差
    }

    public String toString() {
        return new String(strvalue, 0, curlen);   //以字符数组strvalue构造串
    }

    // 模式匹配的Brute-Force 算法
    //返回模式串t在主串中从start开始的第一次匹配位置，匹配失败时返回－1。
    public int index_BF(SeqString t, int start) {
        if (this != null && t != null && t.length() > 0 && this.length() >= t.length()) {  //当主串比模式串长时进行比较
            int slen, tlen, i = start, j = 0;    //i表示主串中某个子串的序号
            slen = this.length();
            tlen = t.length();
            while ((i < slen) && (j < tlen)) {
                if (this.charAt(i) == t.charAt(j)) //j为模式串当前字符的下标
                {
                    i++;
                    j++;
                } //继续比较后续字符
                else {
                    i = i - j + 1;        //继续比较主串中的下一个子串
                    j = 0;                //模式串下标退回到0
                }
            }
            if (j >= t.length()) //一次匹配结束，匹配成功
            {
                return i - tlen;         //返回子串序号
            } else {
                return -1;
            }
        }
        return -1;                     //匹配失败时返回-1
    }

    //若当前串中存在和str相同的子串，则返回模式串str在主串中从第start字符开始的第一次出现位置，否则返回-1
    public int indexOf(IString t, int start) {
        return index_KMP(t, start);
    }

    //KMP模式匹配算法
    public int index_KMP(IString T, int start) {
        //在当前主串中从start开始查找模式串T
        //若找到，则返回模式串T在主串中的首次匹配位置，否则返回-1
        int[] next = getNext(T);     //计算模式串的next[]函数值
        int i = start;               //主串指针
        int j = 0;                   //模式串指针
        //对两串从左到右逐个比较字符
        while (i < this.length() && j < T.length()) {
            //若对应字符匹配
            if (j == -1 || this.charAt(i) == T.charAt(j)) { // j==-1表示S[i]!=T[0]
                i++;
                j++;         //则转到下一对字符
            } else //当S[i]不等于T[j]时
            {
                j = next[j];        //模式串右移
            }
        }
        if (j < T.length()) {
            return -1;                  //匹配失败
        } else {
            return (i - T.length());    //匹配成功
        }
    }

    //计算模式串T的next[]函数值
    private int[] getNext(IString T) {
        int[] next = new int[T.length()];  //next[]数组
        int j = 1;    //主串指针
        int k = 0;   //模式串指针
        next[0] = -1;
        if (T.length()>1)
           next[1] = 0;
        while (j < T.length() - 1) {
            if (T.charAt(j) == T.charAt(k)) {  //匹配
                next[j + 1] = k + 1;
                j++;
                k++;
            } else if (k == 0) {  //失配
                next[j + 1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return (next);
    }

    //计算模式串T的nextval[]函数值
    private int[] getNextVal(IString T) {
        int[] nextval = new int[T.length()];  //nextval[]数组
        int j = 0;
        int k = -1;
        nextval[0] = -1;
        while (j < T.length() - 1) {
            if (k == -1 || T.charAt(j) == T.charAt(k)) {
                j++;
                k++;
                if (T.charAt(j) != T.charAt(k)) {
                    nextval[j] = k;
                } else {
                    nextval[j] = nextval[k];
                }
            } else {
                k = nextval[k];
            }
        }
        return (nextval);
    }

}
