package ch03Exercise;

import ch03.SqStack;

/**
 * 
 * 1.编写一个函数，要求借助一个栈把一个数组中的数据元素逆置。
 * 
 * @author zou
 * 
 */
public class Exercise3_3_1 {
   //借助一个顺序栈将已知一个数组中的数据元素逆置
    public  void reverse(Object [] a) throws Exception {
        SqStack S=new SqStack(a.length); //构造一个容量为a.length的顺序栈
        for(int i=0;i<a.length;i++)
            S.push(a[i]);
        for( int i=0;i<a.length;i++)
            a[i]=S.pop();

        }
    public static void main(String[] args)throws Exception {
		Integer[] a = { 2, 3, 5, 8, 9, 12, 34 };
		System.out.println("逆置前数组中各个数据元素为：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
        Exercise3_3_1 e=new Exercise3_3_1();
        e.reverse(a);
		System.out.println("\n逆置后数组中各个数据元素为：");
        for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

// 调试结果：
// 逆置前数组中各个数据元素为：
// 2 3 5 8 9 12 34
// 逆置后数组中各个数据元素为：
// 34 12 9 8 5 3 2
