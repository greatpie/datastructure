package ch04Exercise;

import ch04.TripleNode;

/**
 *3.6 鞍点是指矩阵中的元素aij是第i行中值最小的元素，同时又是第j列中值最大的元素。
 *试设计一个算法求矩阵A的所有鞍点。
 * @author dux
 */

//存放矩阵中鞍点的类
class Result {

    TripleNode data[];     //三元组表，存放鞍点的行、列、值
    int nums;             //鞍点个数

    public Result(int maxSize) {          //构造方法
        data = new TripleNode[maxSize];    //为顺序表分配maxSize个存储单元
        for (int i = 0; i < data.length; i++) {
            data[i] = new TripleNode();
        }
        nums = 0;
    }
}

public class Exercise4_3_6 {

    public Result allSaddlePoint(int[][] ar) {
        int i, j, flag, m, n;
        Result re = new Result(ar.length);
        for (i = 0; i < ar.length; i++) {
            m = i;
            n = 0;
            flag = 1;   //假设当前结点是鞍点
            for (j = 0; j < ar[i].length; j++) {

                if (ar[i][j] < ar[m][n]) {
                    n = j;
                }
            }
            for (j = 0; j < ar.length; j++) {
                if (ar[j][n] > ar[m][n]) {
                    flag = 0;          //不是鞍点
                }
            }

            if (flag == 1) { //是鞍点，将其加入
                re.data[re.nums] = new TripleNode(m, n, ar[m][n]);
                re.nums++;
            }
        }
        return re;
    }

    public static void main(String args[]) {

        int i, j;
        int a[][] = {{5, 4, 8}, {7, 2, 3}, {9, 1, 6}};
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }
        Exercise4_3_6 ex = new Exercise4_3_6();
        Result re = ex.allSaddlePoint(a);  //求数组a的鞍点，结果保存在re中
        if (re.nums > 0) {
            for (i = 0; i < re.nums; i++) {
                System.out.print("\n第" + re.data[i].getRow() + "行,第" + re.data[i].getColumn() + "列的" + re.data[i].getValue() + "是鞍点\n");
            }
        } else {
            System.out.println("无鞍点");
        }
    }
}

//测试结果：
// 5 4 8
// 7 2 3
// 9 1 6

//第0行,第1列的4是鞍点