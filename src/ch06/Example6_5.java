package ch06;

public class Example6_5 {
	public final static int INFINITY = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Object vexs[] = { "A", "B", "C", "D" };
		int[][] arcs = { { 0, 15, 3, INFINITY }, { 10, 0, 2, INFINITY },
				{ INFINITY, INFINITY, 0, 2 }, { INFINITY, 8, 4, 0 } };
		MGraph G = new MGraph(GraphKind.UDG, 4, 7, vexs, arcs);
		ShortestPath_FLOYD floyd = new ShortestPath_FLOYD();
		floyd.FLOYD(G);
		display(floyd.getD());
		findPlace(G, floyd.getD());

	}

	// 输出各村的最短路径长度
	public static void display(int[][] D) {
		System.out.println("各村之间的最短路径长度为：");
		for (int v = 0; v < D.length; v++) {
			for (int w = 0; w < D.length; w++)
				System.out.print(D[v][w] + "\t");
			System.out.println();
		}
	}

	//求出到其他各顶点最短路径长度之和最小的顶点，并输出最短路径信息
	public static void findPlace(MGraph G, int[][] D) throws Exception {
		int min = INFINITY;
		int sum = 0;// 用于记录一个顶点到其他顶点的最短路径长度的和
		int u = -1;
		for (int v = 0; v < D.length; v++) {
			sum = 0;
			for (int w = 0; w < D.length; w++)
				sum += D[v][w];// 求一点到其他顶点的最短长度之和
			if (min > sum) {
				min = sum;
				u = v;
			}
		}
		System.out.println("俱乐部应设在" + G.getVex(u) + "村，其到各村的路径长度依次为：");
		for (int i = 0; i < D.length; i++)
			System.out.print(D[u][i] + "\t");
		System.out.println();
	}
}
// 调试结果：
// 各村之间的最短路径长度为：
// 0 13 3 5
// 10 0 2 4
// 20 10 0 2
// 18 8 4 0
// 俱乐部应设在B村，其到各村的路径长度依次为：
// 10 0 2 4
