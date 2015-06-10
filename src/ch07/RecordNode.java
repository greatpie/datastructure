package ch07;

/**
 * 顺序表记录结点类
 */
public class RecordNode {

    private Comparable key;      //关键字
    private Object element;      //数据元素

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Comparable getKey() {
        return key;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public RecordNode(Comparable key) {  //构造方法1
        this.key = key;

    }

    public RecordNode(Comparable key, Object element) {  //构造方法2
        this.key = key;
        this.element = element;
    }

    public String toString() { //覆盖toString()方法
        return "[" + key + "," + element + "]";
    }
}
