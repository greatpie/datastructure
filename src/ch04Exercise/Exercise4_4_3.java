package ch04Exercise;

import ch04.CrossList;
import ch04.OLNode;

/**
 *4.3：基于十字链表类CrossList，设计插入非零元素结点的成员函数insert(row,col,val)，并编程测试。
 * @author dux
 */
public class Exercise4_4_3 extends CrossList{
    public  Exercise4_4_3(int row,int col)
    {
        super(row,col);
    }

    @Override
    public void Insert(int row, int col, int e) {  //插入元素
        OLNode rtemp = getRhead()[row - 1];
        OLNode ctemp = getChead()[col - 1];
        OLNode oldtemp = null;
        OLNode current = new OLNode(row, col, e);
        if (rtemp.getRight() == null) {
            rtemp.setRight(current);
        } else {
            while (rtemp.getRight() != null) {
                oldtemp = rtemp;
                rtemp = rtemp.getRight();
                if (rtemp.getCol() > col) {
                    current.setRight(oldtemp.getRight());
                    oldtemp.setRight ( current);
                    break;
                } else //当前位置存在元素
                if (rtemp.getCol() == col) {
                    System.out.println("本位置存在元素");
                    return;
                } else if (rtemp.getRight() == null) {
                    rtemp.setRight ( current);
                    break;
                }
            }
        }
        if (ctemp.getDown() == null) {
            ctemp.setDown(current);
            this.setTu(this.getTu()+1);
        } else {
            while (ctemp.getDown() != null) {
                oldtemp = ctemp;
                ctemp = ctemp.getDown();
                if (ctemp.getRow() > row) {
                    current.setDown(oldtemp.getDown());
                    oldtemp.setDown(current);
                    break;
                } else //当前位置存在元素
                if (ctemp.getRow() == row) {
                    System.out.println("本位置存在元素");
                    return;
                } else if (ctemp.getDown() == null) {
                    ctemp.setDown ( current);
                }
                this.setTu(this.getTu()+1);
                return;
            }
        }
    }

    public static void main(String[] args)  {
    
        int[][] temp = {{0,0,0,0,5},{0,0,0,0,0},{0,0,2,0,0},{0,0,0,8,0}};
        int[] inelem={1,2,3};  //待插入的元素为：第1行第2列元素3
        int row =4;
        int col =5;
        Exercise4_4_3 cl = new Exercise4_4_3(row, col);  //构造十字链表
        for (int i = 0; i < row; i++) {        
            for (int j = 0; j < col; j++) {
                int v = temp[i][j];
                if (v != 0) {
                    cl.Insert(i + 1, j + 1, v);   //插入
                }
            }
        }
        System.out.println("原稀疏矩阵");
        cl.print();      
        cl.Insert(inelem[0],inelem[1],inelem[2]);
        System.out.println("在"+inelem[0]+"行"+inelem[1]+"列插入元素"+inelem[2]+"后的稀疏矩阵");
        cl.print();
    }
}

//测试结果：
/*
 原稀疏矩阵
0 0 0 0 5
0 0 0 0 0
0 0 2 0 0
0 0 0 8 0
在1行2列插入元素3后的稀疏矩阵
0 3 0 0 5
0 0 0 0 0
0 0 2 0 0
0 0 0 8 0
 */