package ch07;

/**
 * 顺序表记录结点关键字类
 */
public class KeyType implements Comparable<KeyType> {

    private int key;   //关键字

    public KeyType() {
    }

    public KeyType(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String toString() { //覆盖toString()方法
        return key +"";
    }

    public int compareTo(KeyType another) {  //覆盖Comparable接口中比较关键字大小的方法
        int thisVal = this.key;
        int anotherVal = another.key;
        return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
    }
}
