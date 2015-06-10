package ch06Exercise;

import ch06.GraphKind;
import ch06.MGraph;

/**
 * 4.编写算法求距离顶点vi的最短路径长度为K的所有顶点。
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_4 {
	public final static int INFINITY = Integer.MAX_VALUE;

	// 用Dijkstra算法求vi顶点到其余顶点v的最短长度D[v]
	public void findVex_DIJ(MGraph G, int vi, int k) throws Exception {
		int vexNum = G.getVexNum();
		int[] R = new int[vexNum];// 存放距离vi距离为k的顶点
		int[] D = new int[vexNum];// vi到其余顶点的最短长度
		boolean isHaveVex = false;// 记录是否存在距离到vi距离为k的点

		boolean[] finish = new boolean[vexNum];
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			R[v] = -1;
			D[v] = G.getArcs()[vi][v];
		}

		D[vi] = 0;// 初始化，vi顶点属于S集
		finish[vi] = true;
		int v = -1;
		int j = 0;// 距离vi长度为k的点的增量

		// 开始主循环，每次求得vi到某个v顶点的最短路径，并加v到S集
		for (int i = 1; i < vexNum; i++) {// 其余G.getVexNum-1个顶点
			int min = INFINITY;// 当前所知离vi顶点的最近距离
			for (int w = 0; w < vexNum; w++) {
				if (!finish[w])
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
			}

			if (min == k) {
				R[j++] = v;
				isHaveVex = true;
			} else if (min > k)
				break;

			finish[v] = true;// 离vi顶点最近的v加入S集

			// 更新当前最短路径及距离
			for (int w = 0; w < vexNum; w++) {
				if (!finish[w] && G.getArcs()[v][w] < INFINITY
						&& (min + G.getArcs()[v][w] < D[w])) { // 修改D[w]和P[w],w属于V-S
					D[w] = min + G.getArcs()[v][w];
				}
			}
		}

		if (isHaveVex) {
			System.out.println("距离vi长度为k的顶点为：");
			for (int i = 0; i < R.length; i++) {
				if (R[i] != -1)
					System.out.print(G.getVex(R[i]) + "\t");
				else
					break;
			}
		} else {
			System.out.println("不存在距离vi长度为k的顶点！");
		}

	}

	public static void main(String[] args) throws Exception {
		Object vexs[] = { "v0", "v1", "v2", "v3", "v4", "v5" };
		int[][] arcs = { { 0, 7, 1, 5, INFINITY, INFINITY },
				{ 7, 0, 6, INFINITY, 3, INFINITY }, { 1, 6, 0, 7, 6, 4 },
				{ 5, INFINITY, 7, 0, INFINITY, 2 },
				{ INFINITY, 3, 6, INFINITY, 0, 7 },
				{ INFINITY, INFINITY, 4, 2, 7, 0 } };
		MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);

		Exercise6_4_4 exercise4_4 = new Exercise6_4_4();
		exercise4_4.findVex_DIJ(G, 0, 5);
	}
}

//调试结果：
//距离vi长度为k的顶点为：
//v3	v5	