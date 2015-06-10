package ch04;

/**
 *三元组顺序表类
 * @author dux
 */
public class TripleNode //三元组结点类
{

    private int row;           //行号
    private int column;        //列号
    private int value;         //元素值

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TripleNode(int row, int column, int value) //有参构造方法
    {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public TripleNode() //无参构造方法
    {
        this(0, 0, 0);
    }

    public String toString() //三元组描述字符串
    {
        return "(" + row + "," + column + "," + value + ")";
    }
}