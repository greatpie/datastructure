package ch06;

public class DTraverser {
	private static boolean[] visited;// 访问标志数组

	// 对图G做深度优先遍历
	public static void DFSTraverse(IGraph G) throws Exception {
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++)
			// 访问标志数组初始化
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])// 对尚未访问的顶点调用DFS
				DFS(G, v);
	}

	// 从第v个顶点出发递归地深度优先遍历图G
	public static void DFS(IGraph G, int v) throws Exception {
		visited[v] = true;
		System.out.print(G.getVex(v).toString() + " ");// 访问第v个顶点
		for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w))
			if (!visited[w])// 对v的尚未访问的邻接顶点w递归调用DFS
				DFS(G, w);
	}

	public static void main(String[] args) throws Exception {
		ALGraph G = GenerateGraph.generateALGraph();
		DTraverser.DFSTraverse(G);
	}
}

// 调试结果：
// v1 v4 v6 v8 v9 v3 v5 v7 v2
