package ch03Exercise;



/**
 * 
 * 3.在一个数组S中保存两个栈：一个栈以数组的第一个存储单元作为栈底，另一个栈以数组的最后一个存储单元作为栈底,即S为一个双向栈。试分别编写入栈push(X,i)和出栈pop(i)操作的函数。其中：push(X,i)表示将数据元素X压入到S中的第i(i=0或1)号栈中；pop(i)表示将S中第i号栈的栈顶元素出栈。
 * 
 * @author zou
 * 
 */

class DuSqStack{
	private Object[] stackElem; // 栈存储空间
	private int top0; //栈顶指针,指示第0号的栈顶元素的下一个位置
    private int top1; //栈顶指针,指示第1号的栈顶元素的下一个位置
    private int base0;//栈尾指针,指示第0号的栈底元素
    private int base1;//栈尾指针,指示第1号的栈底元素
	public DuSqStack(int maxSize) {
		// 初始化栈,即构造一个双向空栈
		stackElem = new Object[maxSize];// 为栈分配maxSize个存储单元
        top0=base0=0;
        top1=base1=maxSize-1;
      }

	
	public void push(Object X, int i) throws Exception {
		// 将数据元素X压入到第i(i的值为0或1)号栈中
        if (top0 > top1) //栈满
			throw new Exception("栈已满");// 抛出异常
        else  if (i==0)
                  stackElem[top0++]=X;
              else if (i==1)
                  stackElem[top1--]=X;
        }

	public Object pop(int i) throws Exception {
         // 将S中第i号栈的栈顶元素出栈,并返回栈顶元素值
		Object x=null;
         if(i==0)
            if (top0==base0)
                throw new Exception("第0号栈为空");
            else
                x=stackElem[--top0];
       
        else  if (i==1)
                  if (top1==base1)
                      throw new Exception("第0号栈为空");
                  else
                       x=stackElem[++top1];
         return x;
	          

       }
     public void display(int i){
         //输出第i号栈中的所有元素(从栈顶到栈底)
         if (i==0){
             for(int j=top0-1;j>0;j--)
                 System.out.print(stackElem[j]+"  ");
             System.out.println();
         }
         else if (i==1){
             for(int j=top1+1;j<stackElem.length;j++)
                 System.out.print(stackElem[j]+"  ");
             System.out.println();
         }

     }
}
public class Exercise3_3_3 {
	public static void main(String[] args) throws Exception {
		Integer[] a = { 1, 3, 5, 7,9 };
        Integer[] b={2, 4, 6, 8,10};
		DuSqStack s=new DuSqStack(100);//构造一个容量为100的双向栈对象
        for (int i=0;i<a.length;i++)
            s.push(a[i], 0);
        for (int i=0;i<a.length;i++)
            s.push(b[i], 1);

        System.out.println("输出栈中的各个数据元素的顺序为(栈顶到栈底)：");
		System.out.println("第0号栈中各个数据元素为：");
		s.display(0);
		System.out.println("第1号栈中各个数据元素为：");
		s.display(1);

		System.out.println("数据\"11\"压入第0号栈后，第0号栈中各个数据元素为：");
		s.push(11, 0);
		s.display(0);
		

		System.out.println("数据\"12\"压入第1号栈后，第1号栈中各个数据元素为：");
		s.push(12, 1);
		s.display(1);

        System.out.println("第0号栈中栈顶元素出栈后，第0号栈中各个数据元素为：");
		s.pop(0);
		s.display(0);
		
		System.out.println("第1号栈中栈顶元素出栈后，第1号栈中各个数据元素为：");
		s.pop(1);
		s.display(1);
		
	}
}

// 调试结果：
//输出栈中的各个数据元素的顺序为(栈顶到栈底)：
//第0号栈中各个数据元素为：
//9  7  5  3
//第1号栈中各个数据元素为：
//10  8  6  4  2
//数据"11"压入第0号栈后，第0号栈中各个数据元素为：
//11  9  7  5  3
//数据"12"压入第1号栈后，第1号栈中各个数据元素为：
//12  10  8  6  4  2
//第0号栈中栈顶元素出栈后，第0号栈中各个数据元素为：
//9  7  5  3
//第1号栈中栈顶元素出栈后，第1号栈中各个数据元素为：
//10  8  6  4  2
