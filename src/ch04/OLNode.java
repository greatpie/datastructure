package ch04;

/**
 *
 * @author dux
 */
public class OLNode {    //十字链表结点类

    int row, col;   //元素的行号、列号
    int e;          //元素值
    OLNode getRight;   //行链表指针
    OLNode getDown;    //列链表指针

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public OLNode getDown() {
        return getDown;
    }

    public void setDown(OLNode down) {
        this.getDown = down;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public OLNode getRight() {
        return getRight;
    }

    public void setRight(OLNode right) {
        this.getRight = right;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public OLNode() {    //无参构造方法
        this(0, 0, 0);
    }

    public OLNode(int row, int col, int e) {  //有参构造方法
        this.row = row;
        this.col = col;
        this.e = e;
        getRight = null;
        getDown = null;
    }
}
