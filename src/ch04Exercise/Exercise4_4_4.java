package ch04Exercise;

import ch04.CrossList;
import ch04.OLNode;

/**
 *4.4 编写程序实现以三元组形式输出用十字链表表示的稀疏矩阵中的非零元素及其下标
 * @author dux
 */
public class Exercise4_4_4 extends CrossList {

    public Exercise4_4_4(int row, int col) { //构造方法
        super(row, col);
    }

    @Override
    public void printByTriple() {  //按照三元组形式输出稀疏矩阵

        if (getTu() == 0) {
            System.out.println("该矩阵为0矩阵");
            return;
        }
        System.out.println("行  列  值");
        for (int i = 0; i < getMu(); i++) {
            OLNode rtemp = getRhead()[i];
            rtemp = rtemp.getRight();
            for (int j = 0; j < getNu(); j++) {
                if (rtemp != null && rtemp.getRow() == i + 1 && rtemp.getCol() == j + 1) {
                    System.out.println(rtemp.getRow() + "   " + rtemp.getCol() + "   " + rtemp.getE());
                    rtemp = rtemp.getRight();      
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] temp = {{0, 0, 0, 0, 5}, {0, 0, 0, 0, 0}, {0, 0, 2, 0, 0}, {0, 0, 0, 8, 0}};
        int row = 4;
        int col = 5;
        Exercise4_4_4 cl = new Exercise4_4_4(row, col);  //构造十字链表
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int v = temp[i][j];
                if (v != 0) {
                    cl.Insert(i + 1, j + 1, v);  //插入结点
                }
            }
        }
        System.out.println("原稀疏矩阵为：");
        cl.print();
        System.out.println("按照三元组形式输出稀疏矩阵为：");
        cl.printByTriple();
    }
}

//测试结果：
/*
原稀疏矩阵为：
0 0 0 0 5
0 0 0 0 0
0 0 2 0 0
0 0 0 8 0
按照三元组形式输出稀疏矩阵为：
行  列  值
1   5   5
3   3   2
4   4   8
 */