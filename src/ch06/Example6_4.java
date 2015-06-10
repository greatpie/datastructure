package ch06;

public class Example6_4 {
	public final static int INFINITY = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Object vexs[] = { "v0", "v1", "v2", "v3", "v4", "v5" };
		int[][] arcs = { { 0, 7, 1, 5, INFINITY, INFINITY },
				{ 7, 0, 6, INFINITY, 3, INFINITY }, { 1, 6, 0, 7, 6, 4 },
				{ 5, INFINITY, 7, 0, INFINITY, 2 },
				{ INFINITY, 3, 6, INFINITY, 0, 7 },
				{ INFINITY, INFINITY, 4, 2, 7, 0 } };
		MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);
		Object[][] T = new MiniSpanTree_PRIM().PRIM(G, "v1");
		for (int i = 0; i < T.length; i++)
			System.out.println(T[i][0] + " - " + T[i][1]);
	}
}
// 调试结果：
// v1 - v4
// v1 - v2
// v2 - v0
// v2 - v5
// v5 - v3
