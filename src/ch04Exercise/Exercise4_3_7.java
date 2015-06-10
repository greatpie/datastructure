package ch04Exercise;

/**
 *3.7 设计算法，求出二维数组A[n,n]的两条对角线元素之和
 * @author dux
 */
public class Exercise4_3_7 {

    public static int sumOfDiagonal(int[][] a) {
        int i, n = a[0].length, sum1 = 0, sum2 = 0, sum;
        for (i = 0; i < a.length; i++) {
            sum1 += a[i][i];            //主对角线之和
            sum2 += a[i][n - i - 1];    //副对角线之和
        }
        sum = sum1 + sum2;
        if (n % 2 == 1) {    //若矩阵行数为奇数，则减去两条对角线相交的元素。
            sum -= a[n / 2][n / 2];
        }
        return sum;
    }

    public static void main(String args[]) {

        int i, j;
        int n = 3;
        int a[][] = new int[n][n];
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * 10); //产生n*n个随机数
                System.out.print(" " + a[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n对角线元素之和为" + sumOfDiagonal(a));
    }
}

//测试结果：
// 3 2 5
// 4 8 9
// 2 4 3

//对角线元素之和为21

