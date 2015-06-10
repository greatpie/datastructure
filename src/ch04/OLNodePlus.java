package ch04;

import FinalWork.WordWithFrequency;

/**
 *
 * @author dux
 */
public class OLNodePlus {    //十字链表结点类

    int row, col;   //元素的行号、列号
    WordWithFrequency e;          //元素值
    OLNodePlus getRight;   //行链表指针
    OLNodePlus getDown;    //列链表指针

    public int getCol() {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public OLNodePlus getDown() {
        return getDown;
    }

    public void setDown(OLNodePlus down) {
        this.getDown = down;
    }

    public WordWithFrequency getE() {
        return e;
    }

    public void setE(WordWithFrequency e) {
        this.e = e;
    }

    public OLNodePlus getRight() {
        return getRight;
    }

    public void setRight(OLNodePlus right) {
        this.getRight = right;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public OLNodePlus() {    //无参构造方法
        this(0, 0, null);
    }

    public OLNodePlus(int row, int col, WordWithFrequency e) {  //有参构造方法
        this.row = row;
        this.col = col;
        this.e = e;
        getRight = null;
        getDown = null;
    }
}
