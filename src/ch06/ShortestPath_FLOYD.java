package ch06;

public class ShortestPath_FLOYD {
	private boolean[][][] P;// 顶点v和w之间的最短路径P[v][w]，若P[v][w][u]为true，则u是从v到w当前求得最短路径上的顶点

	private int[][] D;// 顶点v和w之间最短路径的带权长度D[v][w]

	public final static int INFINITY = Integer.MAX_VALUE;

	// 用Dijkstra算法求有向网G的v0顶点到其余顶点v的最短路径P[v]及其权值D[v]
	public void FLOYD(MGraph G) {
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum][vexNum];
		D = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++) // 各对结点之间初始化已知路径及距离
			for (int w = 0; w < vexNum; w++) {
				D[v][w] = G.getArcs()[v][w];
				for (int u = 0; u < vexNum; u++)
					P[v][w][u] = false;
				if (D[v][w] < INFINITY) {// 从v到w有直接路径
					P[v][w][v] = true;
					P[v][w][w] = true;
				}
			}
		for (int u = 0; u < vexNum; u++)
			for (int v = 0; v < vexNum; v++)
				for (int w = 0; w < vexNum; w++)
					if (D[v][u] < INFINITY && D[u][w] < INFINITY
							&& D[v][u] + D[u][w] < D[v][w]) { // 从v经u到w的一条路径最短
						D[v][w] = D[v][u] + D[u][w];
						for (int i = 0; i < vexNum; i++)
							P[v][w][i] = P[v][u][i] || P[u][w][i];
					}
	}

	public int[][] getD() {
		return D;
	}

	public boolean[][][] getP() {
		return P;
	}

}
