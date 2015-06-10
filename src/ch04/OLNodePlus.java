package ch04;

import FinalWork.WordWithFrequency;

/**
 *
 * @author dux
 */
public class OLNodePlus {    //ʮ����������

    int row, col;   //Ԫ�ص��кš��к�
    WordWithFrequency e;          //Ԫ��ֵ
    OLNodePlus getRight;   //������ָ��
    OLNodePlus getDown;    //������ָ��

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

    public OLNodePlus() {    //�޲ι��췽��
        this(0, 0, null);
    }

    public OLNodePlus(int row, int col, WordWithFrequency e) {  //�вι��췽��
        this.row = row;
        this.col = col;
        this.e = e;
        getRight = null;
        getDown = null;
    }
}
