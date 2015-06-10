package ch06;

//【例6.2】编程实现判断一个有向图中任意给定的两个顶点之间是否存在一条长度为k的简单路径。

public class Example6_2 {
	private boolean[] visited;// 访问标志数组

	private int i = 0;// 辅助变量，在遍历过程中用于记录从源点出发的路径长度

	private boolean find = false;// 标示是否已找到了指定长度的路径

	public void findPath(IGraph G, int u, int v, int k) throws Exception {
		visited = new boolean[G.getVexNum()];
		for (int w = 0; w < G.getVexNum(); w++)
			// 访问标志数组初始化
			visited[w] = false;
		find_DFS(G, u, v, k);
		if (find)
			System.out.println(G.getVex(u) + "和" + G.getVex(v) + "之间存在一条长度为"
					+ k + "的简单路径");
		else
			System.out.println(G.getVex(u) + "和" + G.getVex(v) + "之间不存在一条长度为"
					+ k + "的简单路径");
	}

	private void find_DFS(IGraph G, int u, int v, int k) throws Exception {
		if (i == k && u == v)
			find = true;
		else if (!find) {
			visited[u] = true;
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w]) {
					if (i < k) {
						++i;
						find_DFS(G, w, v, k);// 对v的尚未访问的邻接顶点w递归调用find_DFS
					} else
						break;// 若路径长度已达到k值而仍未找到简单路径，则不再继续对当前顶点进行深度优先搜索
				}
			--i;// 回退一个顶点
		}
	}

	public static void main(String[] args) throws Exception {
		ArcNode ab = new ArcNode(1);
		VNode A = new VNode("A", ab);

		ArcNode bc = new ArcNode(2);
		ArcNode be = new ArcNode(4, 0, bc);
		VNode B = new VNode("B", be);

		ArcNode cd = new ArcNode(3);
		VNode C = new VNode("C", cd);

		ArcNode de = new ArcNode(4);
		VNode D = new VNode("D", de);

		ArcNode ef = new ArcNode(5);
		VNode E = new VNode("E", ef);

		ArcNode fa = new ArcNode(0);
		ArcNode fb = new ArcNode(1, 0, fa);
		VNode F = new VNode("F", fb);

		VNode[] vexs = { A, B, C, D, E, F };
		ALGraph G = new ALGraph(GraphKind.DG, 6, 8, vexs);
		Example6_2 e = new Example6_2();
		e.findPath(G, 0, 5, 3);
	}
}
// A和F之间存在一条长度为3的简单路径
