package ch06Exercise;

import ch03.LinkQueue;
import ch06.ALGraph;
import ch06.ArcNode;
import ch06.GraphKind;
import ch06.IGraph;
import ch06.VNode;

/**
 * 2. 无向图采用邻接表存储结构，编写算法输出图中各连通分量的顶点序列。
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_2 {

	public static void CC_BFS(IGraph G) throws Exception {
		boolean[] visited = new boolean[G.getVexNum()];// 访问标志数组
		for (int v = 0; v < G.getVexNum(); v++)
			// 访问标志数组初始化
			visited[v] = false;
		LinkQueue Q = new LinkQueue();// 辅助队列Q
		LinkQueue P = new LinkQueue();// 辅助队列P,用于记录连通分量的顶点
		int i = 0;// 用于记数连通分量的个数
		for (int v = 0; v < G.getVexNum(); v++) {
			P.clear();// 队列清空
			if (!visited[v]) {// v尚未访问
				visited[v] = true;
				P.offer(G.getVex(v));
				Q.offer(v);// v入队列
				while (!Q.isEmpty()) {
					int u = (Integer) Q.poll();// 队头元素出队列并赋值给u
					for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u,
							w)) {
						if (!visited[w]) {// w为u的尚未访问的邻接顶点
							visited[w] = true;
							P.offer(G.getVex(w));
							Q.offer(w);
						}
					}
				}
				System.out.println("图的第" + ++i + "个连通分量为：");
				while (!P.isEmpty())
					System.out.print(P.poll().toString() + " ");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ArcNode v12 = new ArcNode(1);
		ArcNode v13 = new ArcNode(2, 0, v12);
		VNode v1 = new VNode("v1", v13);

		ArcNode v21 = new ArcNode(0);
		ArcNode v24 = new ArcNode(3, 0, v21);
		VNode v2 = new VNode("v2", v24);

		ArcNode v31 = new ArcNode(0);
		ArcNode v34 = new ArcNode(3, 0, v31);
		VNode v3 = new VNode("v3", v34);

		ArcNode v42 = new ArcNode(1);
		ArcNode v43 = new ArcNode(2, 0, v42);
		VNode v4 = new VNode("v4", v43);

		ArcNode v56 = new ArcNode(5);
		ArcNode v57 = new ArcNode(6, 0, v56);
		VNode v5 = new VNode("v5", v57);

		ArcNode v65 = new ArcNode(4);
		VNode v6 = new VNode("v6", v65);

		ArcNode v75 = new ArcNode(4);
		VNode v7 = new VNode("v7", v75);

		VNode[] vexs = { v1, v2, v3, v4, v5, v6, v7 };
		ALGraph G = new ALGraph(GraphKind.UDG, 7, 12, vexs);
		CC_BFS(G);
	}
}

//调试结果：
//图的第1个连通分量为：
//v1 v3 v2 v4 
//图的第2个连通分量为：
//v5 v7 v6 