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
        //��ȡ���ڵ�
        BiTreeNode T = pie.getRoot();
        if(T != null){
            //�������
            LinkQueue queue = new LinkQueue();
            //����ջ
            LinkStack stack = new LinkStack();
            //�����ڵ�������
            queue.offer(T);

            //���Ѻ�ջ��һ����Ϊ��ʱ����
            while (!queue.isEmpty() || !stack.isEmpty()){
                //�ڶ��н��в���ʱ�������ӽڵ�ѹ��ջ������лᱻȡ��
               while (!queue.isEmpty()){
                   T = (BiTreeNode)queue.poll();
                   //���ʴ˽ڵ�
                   System.out.print(T.getData()+" ,");
                   //������ӽڵ���ڽ���ڵ�ѹ��ջ
                   if (T.getLchild() != null){
                       stack.push(T.getLchild());
                   }
                   //����Һ��ӽڵ���ڽ���ڵ�ѹ��ջ
                   if (T.getRchild() != null){
                       stack.push(T.getRchild());
                   }
               }
                //��ջ���в���ʱ�������ӽڵ������У���ջ�ᱻȡ��
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
