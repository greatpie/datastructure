package ch08Exercise;

/**
 * 4.1:已知关键字序列{8,30，43,52,59,80,83,100}，设计程序，要求采用带监视哨的顺序查找算法完成以下功能：
 *    ⑴ 查找关键字为83的数据元素，若找到，则输出该数据元素在表中的位置，否则给出查找失败的提示信息。
 *    ⑵ 查找关键字为36的数据元素，若找到，则输出该数据元素在表中的位置，否则给出查找失败的提示信息。
 * @author dux
 */
import ch07.*;
import java.util.Scanner;

public class Exercise8_4_1 {

    static SeqList ST = null;

    public static void createSearchList() throws Exception {
        int maxSize = 20;  //查找表预分配空间的大小
        ST = new SeqList(maxSize);    //创建查找表对象
        int curlen;       //表的实际长度
        int[] d={8,30,43,52,59,80,83,100};   
        curlen = d.length;
        KeyType[] k = new KeyType[curlen];
        System.out.println("关键码序列：");
        for (int i = 0; i < curlen; i++) {  //输入关键字序列
            k[i] = new KeyType(d[i]);
            System.out.print(d[i]+" ");
        }
        System.out.println("");
        for (int i = 0; i < curlen; i++) {  //记录顺序表
            RecordNode r = new RecordNode(k[i]);
            ST.insert(ST.length(), r);
        }
    }

    public static void main(String[] args) throws Exception {
        createSearchList();   //创建查找表
        System.out.println("请输入2个待查找的关键字:");  //提示输入待查找的关键字
        Scanner sc = new Scanner(System.in); //输入待查找关键字
        KeyType key1 = new KeyType(sc.nextInt());
        KeyType key2 = new KeyType(sc.nextInt());
        System.out.println("seqSearchWithGuard(" + key1.getKey() + ")=" + ST.seqSearchWithGuard(key1));
        System.out.println("seqSearchWithGuard(" + key2.getKey() + ")=" + ST.seqSearchWithGuard(key2));
    }
}

//测试结果：
/*
关键码序列：
8 30 43 52 59 80 83 100
请输入2个待查找的关键字:
52 78
seqSearchWithGuard(52)=3
seqSearchWithGuard(78)=-1
 */