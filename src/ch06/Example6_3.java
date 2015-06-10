package ch06;

import ch03.LinkStack;

public class Example6_3 {
	private boolean[] visited;// 访问标志数组

	private LinkStack S = new LinkStack();// 按深度优先搜索访问的先后顺序记录在一个连通分支当中的顶点元素

	private boolean find = false;// 标示是否已找到了环

	public void findCicle(IGraph G) throws Exception {
		visited = new boolean[G.getVexNum()];
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++)
			// 访问标志数组初始化
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])// 对尚未访问的顶点调用DFS
				find_DFS(G, v);
		if (find)
			System.out.println("此有向图存在环!");
		else
			System.out.println("此有向图不存在环!");
	}

	public void find_DFS(IGraph G, int v) throws Exception {
		if (!find) {
			visited[v] = true;
			S.push(v);
			for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w))
				if (visited[w] && isDuplicate(w))
					find = true;
				else
					// 对v的尚未访问的邻接顶点w递归调用DFS
					find_DFS(G, w);
			S.pop();
		}
	}

	// 判断栈S中是否存在值为w的数据元素
	private boolean isDuplicate(Integer w) throws Exception {
		LinkStack S1 = new LinkStack();// 辅助栈
		while (!S.isEmpty() && !((Integer) S.peek()).equals(w))
			// 判断栈S中是否存在为w的数据元素，并利用辅助栈S1，记录出栈的元素
			S1.push(S.pop());

		if (S.isEmpty()) {// 重新把数据元素放入栈S
			while (!S1.isEmpty())
				S.push(S1.pop());
			return false;
		} else
			return true;
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
		Example6_3 e = new Example6_3();
		e.findCicle(G);
	}
}
//此有向图存在环!
