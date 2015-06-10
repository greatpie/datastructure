package ch04;



public class CrossList {   //十字链表

    private int mu, nu, tu;  //行数、列数、非零元素个数
    private OLNode[] rhead, chead; //行、列指针数组

    public OLNode[] getChead() {
        return chead;
    }

    public void setChead(OLNode[] chead) {
        this.chead = chead;
    }

    public int getMu() {
        return mu;
    }

    public void setMu(int mu) {
        this.mu = mu;
    }

    public int getNu() {
        return nu;
    }

    public void setNu(int nu) {
        this.nu = nu;
    }

    public OLNode[] getRhead() {
        return rhead;
    }

    public void setRhead(OLNode[] rhead) {
        this.rhead = rhead;
    }

    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public CrossList(){}
    public CrossList(int m, int n) {  //构造方法，初始化
        mu = m;
        nu = n;
        rhead = new OLNode[m];     //初始化行指针数组
        chead = new OLNode[n];     //初始化列指针数组
        tu = 0;
        for (int i = 0; i < m; i++) {
            rhead[i] = new OLNode();
        }
        for (int i = 0; i < n; i++) {
            chead[i] = new OLNode();
        }
    }

    public void Insert(int row, int col, int e) {  //插入元素
        OLNode rtemp = rhead[row - 1];
        OLNode ctemp = chead[col - 1];
        OLNode oldtemp = null;
        OLNode current = new OLNode(row, col, e);
        if (rtemp.getRight == null) {

            rtemp.getRight = current;

        } else {
            while (rtemp.getRight != null) {
                oldtemp = rtemp;
                rtemp = rtemp.getRight;
                if (rtemp.col > col) {
                    current.getRight = oldtemp.getRight;
                    oldtemp.getRight = current;

                    break;
                } else //但前位置存在 操作可以写覆盖 也可以相加
                if (rtemp.col == col) {
                    System.out.println("本位置存在1");
                    return;
                } else if (rtemp.getRight == null) {
                    rtemp.getRight = current;

                    break;
                }

            }
        }
        if (ctemp.getDown == null) {
            ctemp.getDown = current;
            tu++;
        } else {
            while (ctemp.getDown != null) {
                oldtemp = ctemp;
                ctemp = ctemp.getDown;
                if (ctemp.row > row) {
                    current.getDown = oldtemp.getDown;
                    oldtemp.getDown = current;
                    break;
                } else //但前位置存在 操作可以写覆盖 也可以相加
                if (ctemp.row == row) {
                    System.out.println("本位置存在2");
                    return;
                } else if (ctemp.getDown == null) {
                    ctemp.getDown = current;
                }
                tu++;
                return;
            }
        }
    }

    public void del(int row, int col, int e) {
        OLNode rtemp = rhead[row - 1];
        OLNode ctemp = chead[col - 1];
        OLNode oldtemp = null;
        int flag = 0;
        while (rtemp.getRight != null) {
            oldtemp = rtemp;
            rtemp = rtemp.getRight;
            if (rtemp.row == row && rtemp.col == col) {
                oldtemp.getRight = rtemp.getRight;
                flag = 1;
                break;
            }

        }

        while (ctemp.getDown != null) {
            oldtemp = ctemp;
            ctemp = ctemp.getDown;
            if (ctemp.row == row && rtemp.col == col) {
                oldtemp.getDown = ctemp.getDown;
                tu--;
                System.out.println("找到该位置并且把该位置物理上删除");
                return;
            }

        }
    }

    public void zz() {
    }

    public void print() {

        if (tu == 0) {
            System.out.println("该矩阵为0矩阵");
            return;
        }
        for (int i = 0; i < mu; i++) {
            OLNode rtemp = rhead[i];
            rtemp = rtemp.getRight;

            for (int j = 0; j < nu; j++) {
                if (rtemp != null && rtemp.row == i + 1 && rtemp.col == j + 1) {
                    System.out.print(rtemp.e);

                    rtemp = rtemp.getRight;
                } else {
                    System.out.print("0");
                }
                if (j != nu - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public void print2() {    //矩阵转置

        if (tu == 0) {
            System.out.println("该矩阵为0矩阵");
            return;
        }
        for (int i = 0; i < nu; i++) {
            OLNode ctemp = chead[i];
            ctemp = ctemp.getDown;

            for (int j = 0; j < mu; j++) {
                if (ctemp != null && ctemp.col == i + 1 && ctemp.row == j + 1) {
                    System.out.print(ctemp.e);

                    ctemp = ctemp.getDown;
                } else {
                    System.out.print("0");
                }
                if (j != mu - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public void printByTriple() {  //按照三元组形式输出稀疏矩阵

        if (tu == 0) {
            System.out.println("该矩阵为0矩阵");
            return;
        }
        System.out.println("行  列  值");
        for (int i = 0; i < mu; i++) {
            OLNode rtemp = rhead[i];
            rtemp = rtemp.getRight;
            for (int j = 0; j < nu; j++) {
                if (rtemp != null && rtemp.row == i + 1 && rtemp.col == j + 1) {
                    System.out.println(rtemp.row + "   " + rtemp.col + "   " + rtemp.e);
                    rtemp = rtemp.getRight;
                }
            }
        }

    }
}
