package ch06Exercise;

import ch06.GraphKind;
import ch06.MGraph;

/**
 * 1.在邻接矩阵存储结构上实现图的基本操作：InsertArc(G,v,w, P)，DeleteArc(G,v,w)。
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_5_1 {
	public final static int INFINITY = Integer.MAX_VALUE;

	void insertArc(MGraph G, Object v, Object w, int P) {
		int iv = G.locateVex(v);
		int iw = G.locateVex(w);
		int[][] arcs = G.getArcs();
		arcs[iv][iw] = P;
		G.setArcs(arcs);
		G.setArcNum(G.getArcNum() + 1);
	}

	void deleteArc(MGraph G, Object v, Object w) {
		int iv = G.locateVex(v);
		int iw = G.locateVex(w);
		int[][] arcs = G.getArcs();
		arcs[iv][iw] = INFINITY;
		G.setArcs(arcs);
		G.setArcNum(G.getArcNum() - 1);
	}

	public static void main(String[] args) throws Exception {
		Object vexs[] = { "v0", "v1", "v2", "v3", "v4", "v5" };
		int[][] arcs = { { 0, 7, 1, 5, INFINITY, INFINITY },
				{ 7, 0, 6, INFINITY, 3, INFINITY }, { 1, 6, 0, 7, 6, 4 },
				{ 5, INFINITY, 7, 0, INFINITY, 2 },
				{ INFINITY, 3, 6, INFINITY, 0, 7 },
				{ INFINITY, INFINITY, 4, 2, 7, 0 } };
		MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);
		System.out.println("修改前图的边数为：" + G.getArcNum());

		Exercise6_5_1 exercise5_1 = new Exercise6_5_1();
		exercise5_1.deleteArc(G, "v0", "v1");
		System.out.println("删除V0-V1边后，图的边数为：" + G.getArcNum());
		exercise5_1.insertArc(G, "v0", "v1", 7);
		System.out.println("增加V0-V1边后，图的边数为：" + G.getArcNum());
	}

}

//调试结果：
//修改前图的边数为：10
//删除V0-V1边后，图的边数为：9
//增加V0-V1边后，图的边数为：10
