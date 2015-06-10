package ch06;

//【例6.1】编程实现应用广度优先搜索算法确定无向图的连通分量。
import ch03.LinkQueue;

public class Example6_1 {
	public final static int INFINITY = Integer.MAX_VALUE;

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
		Object vexs[] = { "A", "B", "C", "D", "E", "F", "G" };
		int[][] arcs = { { 0, 1, INFINITY, 1, INFINITY, INFINITY, INFINITY },
				{ 1, 0, 1, INFINITY, INFINITY, INFINITY, INFINITY },
				{ INFINITY, 1, 0, 1, INFINITY, INFINITY, INFINITY },
				{ 1, INFINITY, 1, 0, INFINITY, INFINITY, INFINITY },
				{ INFINITY, INFINITY, INFINITY, INFINITY, 0, 1, INFINITY },
				{ INFINITY, INFINITY, INFINITY, INFINITY, 1, 0, 1 },
				{ INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 1, 0 }, };
		MGraph G = new MGraph(GraphKind.UDG, 7, 6, vexs, arcs);
		CC_BFS(G);
	}
}
// 调试结果：
// 图的第1个连通分量为：
// A B D C
// 图的第2个连通分量为：
// E F G
