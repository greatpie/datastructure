package ch05Exercise;

import ch03.LinkQueue;
import ch03.LinkStack;
import ch03.SqStack;
import ch05.BiTree;
import ch05.BiTreeNode;

/**
 * Created by pie on 2015-5-24.
 */
public class LevelTraverse {
    public static void main(String[] args){
        BiTree pie = new BiTree();
        //获取根节点
        BiTreeNode T = pie.getRoot();
        if(T != null){
            //构造队列
            LinkQueue queue = new LinkQueue();
            //构造栈
            LinkStack stack = new LinkStack();
            //将根节点放入队列
            queue.offer(T);

            //当堆和栈有一个不为空时继续
            while (!queue.isEmpty() || !stack.isEmpty()){
                //在队列进行操作时，将孩子节点压入栈，则队列会被取空
               while (!queue.isEmpty()){
                   T = (BiTreeNode)queue.poll();
                   //访问此节点
                   System.out.print(T.getData()+" ,");
                   //如果左孩子节点存在将左节点压入栈
                   if (T.getLchild() != null){
                       stack.push(T.getLchild());
                   }
                   //如果右孩子节点存在将左节点压入栈
                   if (T.getRchild() != null){
                       stack.push(T.getRchild());
                   }
               }
                //在栈进行操作时，将孩子节点放入队列，则栈会被取空
               while (!stack.isEmpty()){
                   T = (BiTreeNode)stack.pop();
                   System.out.print(T.getData()+" ,");
                   if (T.getLchild() != null){
                       queue.offer(T.getLchild());
                   }
                   if (T.getRchild() != null){
                       queue.offer(T.getRchild());
                   }
               }

            }

        }

    }
}
