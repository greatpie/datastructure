package ch04;


import FinalWork.WordCounter;
import FinalWork.WordWithFrequency;
import tools.TextReader;

public class CrossListPlus {   //ʮ������

    private int mu, nu, tu;  //����������������Ԫ�ظ���
    private OLNodePlus[] rhead, chead; //�С���ָ������

    public OLNodePlus[] getChead() {
        return chead;
    }

    public void setChead(OLNodePlus[] chead) {
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

    public OLNodePlus[] getRhead() {
        return rhead;
    }

    public void setRhead(OLNodePlus[] rhead) {
        this.rhead = rhead;
    }

    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public CrossListPlus(){
    }
    public CrossListPlus(int m, int n) {  //���췽������ʼ��
        mu = m;
        nu = n;
        rhead = new OLNodePlus[m];     //��ʼ����ָ������
        chead = new OLNodePlus[n];     //��ʼ����ָ������
        tu = 0;
        for (int i = 0; i < m; i++) {
            rhead[i] = new OLNodePlus();
        }
        for (int i = 0; i < n; i++) {
            chead[i] = new OLNodePlus();
        }
    }

    public void Insert(int row, int col, WordWithFrequency e) {  //����Ԫ��
        OLNodePlus rtemp = rhead[row - 1];
        OLNodePlus ctemp = chead[col - 1];
        OLNodePlus oldtemp = null;
        OLNodePlus current = new OLNodePlus(row, col, e);
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
                } else //��ǰλ�ô��� ��������д���� Ҳ�������
                    if (rtemp.col == col) {
                        System.out.println("��λ�ô���1");
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
                } else //��ǰλ�ô��� ��������д���� Ҳ�������
                    if (ctemp.row == row) {
                        System.out.println("��λ�ô���2");
                        return;
                    } else if (ctemp.getDown == null) {
                        ctemp.getDown = current;
                    }
                tu++;
                return;
            }
        }
    }

    public void del(int row, int col, String e) {
        OLNodePlus rtemp = rhead[row - 1];
        OLNodePlus ctemp = chead[col - 1];
        OLNodePlus oldtemp = null;
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
                System.out.println("�ҵ���λ�ò��ҰѸ�λ��������ɾ��");
                return;
            }

        }
    }

    public void zz() {
    }

    public void print() {

        if (tu == 0) {
            System.out.println("�þ���Ϊ0����");
            return;
        }
        for (int i = 0; i < mu; i++) {
            OLNodePlus rtemp = rhead[i];
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

    public void print2() {    //����ת��

        if (tu == 0) {
            System.out.println("�þ���Ϊ0����");
            return;
        }
        for (int i = 0; i < nu; i++) {
            OLNodePlus ctemp = chead[i];
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

    public void printByTriple() {  //������Ԫ����ʽ���ϡ�����

        if (tu == 0) {
            System.out.println("�þ���Ϊ0����");
            return;
        }
        System.out.println("��  ��  ֵ");
        for (int i = 0; i < mu; i++) {
            OLNodePlus rtemp = rhead[i];
            rtemp = rtemp.getRight;
            for (int j = 0; j < nu; j++) {
                if (rtemp != null && rtemp.row == i + 1 && rtemp.col == j + 1) {
                    System.out.println(rtemp.row + "   " + rtemp.col + "   " + rtemp.e);
                    rtemp = rtemp.getRight;
                }
            }
        }

    }

    public static void main(String[] args){
        String text = TextReader.readTxtFile("test_text.txt");
        //���������ո񻮷ֶ���
        String[] paragraph = text.split("  ");
        for (int i=0;i<paragraph.length;i++){
            WordCounter counter = new WordCounter(paragraph[i]);
            counter.count();
            WordWithFrequency[][] wordResult= counter.getWordResult();

        }
    }
}
