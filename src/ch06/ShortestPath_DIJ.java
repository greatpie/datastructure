package ch06;

public class ShortestPath_DIJ {
	private boolean[][] P;// v0到其余顶点的最短路径, 若P[v][w]为true，则w是从v0到v当前求得最短路径上的顶点

	private int[] D;// v0到其余顶点的带权长度

	public final static int INFINITY = Integer.MAX_VALUE;

	// 用Dijkstra算法求有向网G的v0顶点到其余顶点v的最短路径P[v]及其权值D[v]
	public void DIJ(MGraph G, int v0) {
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum];
		D = new int[vexNum];
		boolean[] finish = new boolean[vexNum];// finish[v]为true当且仅当v属于S,即已经求得从v0到v的最短路径
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			for (int w = 0; w < vexNum; w++)
				P[v][w] = false;// 设空路径
			if (D[v] < INFINITY) {
				P[v][v0] = true;
				P[v][v] = true;
			}
		}

		D[v0] = 0;// 初始化，v0顶点属于S集
		finish[v0] = true;
		int v = -1;

		// 开始主循环，每次求得v0到某个v顶点的最短路径，并加v到S集
		for (int i = 1; i < vexNum; i++) {// 其余G.getVexNum-1个顶点
			int min = INFINITY;// 当前所知离v0顶点的最近距离
			for (int w = 0; w < vexNum; w++)
				if (!finish[w])
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
			finish[v] = true;// 离v0顶点最近的v加入S集

			for (int w = 0; w < vexNum; w++)
				// 更新当前最短路径及距离
				if (!finish[w] && G.getArcs()[v][w] < INFINITY
						&& (min + G.getArcs()[v][w] < D[w])) { // 修改D[w]和P[w],w属于V-S
					D[w] = min + G.getArcs()[v][w];
					System.arraycopy(P[v], 0, P[w], 0, P[v].length);
					P[w][w] = true;
				}
		}
	}

	public int[] getD() {
		return D;
	}

	public boolean[][] getP() {
		return P;
	}
	
	public static void main(String[] args) throws Exception {
		MGraph G = GenerateGraph.generateMGraph();
		ShortestPath_DIJ dij = new ShortestPath_DIJ();
		dij.DIJ(G, 0);
		dij.display(G);
	}

	// 用于输出最短路径上的各各顶点及权值
	public void display(MGraph G) throws Exception {
		if (D != null) {
			System.out.println("各各顶点到v0的最短路径上的点及最短距离分别是：");
			for (int i = 0; i < P.length; i++) {
				System.out.print("v0 - " + G.getVex(i) + ": ");
				for (int j = 0; j < P[i].length; j++) {
					if (P[i][j])
						System.out.print(G.getVex(j) + "\t");
				}
				System.out.println("最短距离为： " + D[i]);
			}
		}
	}

}

// 调试结果：
// 各各顶点到v0的最短路径上的点及最短距离分别是：
// v0 - v0: v0 最短距离为： 0
// v0 - v1: v0 v1 最短距离为： 7
// v0 - v2: v0 v2 最短距离为： 1
// v0 - v3: v0 v3 最短距离为： 5
// v0 - v4: v0 v2 v4 最短距离为： 7
// v0 - v5: v0 v2 v5 最短距离为： 5
