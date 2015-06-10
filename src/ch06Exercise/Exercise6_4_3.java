package ch06Exercise;

import ch06.ALGraph;
import ch06.ArcNode;
import ch06.GraphKind;
import ch06.IGraph;
import ch06.VNode;

/**
 * 3.编写算法判别以邻接表方式存储的无向图中是否存在由顶点u到顶点v的路径（u ≠v）。
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_3 {

	private boolean[] visited;// 访问标志数组

	private boolean find = false;// 标示是否已找到了指定长度的路径

	public void findPath(IGraph G, int u, int v) throws Exception {
		visited = new boolean[G.getVexNum()];
		for (int w = 0; w < G.getVexNum(); w++)
			// 访问标志数组初始化
			visited[w] = false;
		find_DFS(G, u, v);
		if (find)
			System.out.println(G.getVex(u) + "和" + G.getVex(v) + "之间至少存在一条路径！");
		else
			System.out.println(G.getVex(u) + "和" + G.getVex(v) + "之间不存在路径！");
	}

	private void find_DFS(IGraph G, int u, int v) throws Exception {
		if (u == v) {
			find = true;
		} else if (!find) {
			visited[u] = true;
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w])
					find_DFS(G, w, v);// 对v的尚未访问的邻接顶点w递归调用find_DFS

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
		Exercise6_4_3 exercise4_3 = new Exercise6_4_3();
		exercise4_3.findPath(G, 0, 4);

		exercise4_3 = new Exercise6_4_3();
		exercise4_3.findPath(G, 0, 5);
	}
}

//调试结果：
//v1和v5之间不存在路径！
//v1和v6之间不存在路径！