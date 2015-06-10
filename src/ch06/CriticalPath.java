package ch06;

import ch03.LinkStack;

public class CriticalPath {
	private LinkStack T = new LinkStack();// 拓扑逆序列顶点栈

	private int[] ve, vl;// 各顶点的最早发生时间和最迟发生时间

	// 有向网G采用邻接表存储结构，求各顶点的最早发生时间ve，若G无回路，则用栈T返回G的一个拓扑序列，且函数返回true，否则为false
	public boolean topologicalOrder(ALGraph G) throws Exception {
		int count = 0;// 输出顶点计数
		int[] indegree = TopologicalSort.findInDegree(G);// 求各顶点入度
		LinkStack S = new LinkStack();// 建零入度顶点栈S
		for (int i = 0; i < G.getVexNum(); i++)
			if (indegree[i] == 0)// 入度为0者进栈
				S.push(i);
		ve = new int[G.getVexNum()];// 初始化
		while (!S.isEmpty()) {
			int j = (Integer) S.pop();
			T.push(j);// j号顶点入T栈并计数
			++count;
			for (ArcNode arc = G.getVexs()[j].getFirstArc(); arc != null; arc = arc
					.getNextArc()) {
				int k = arc.getAdjVex();
				if (--indegree[k] == 0)// 对j号顶点的每个邻接点的入度减1
					S.push(k);// 若入度减为0，则入栈
				if (ve[j] + arc.getValue() > ve[k])
					ve[k] = ve[j] + arc.getValue();
			}
		}

		if (count < G.getVexNum())
			return false;// 该有向图有回路
		else
			return true;
	}

	// G为有向网，输出G的各项关键活动
	public boolean criticalPath(ALGraph G) throws Exception {
		if (!topologicalOrder(G))
			return false;
		vl = new int[G.getVexNum()];
		for (int i = 0; i < G.getVexNum(); i++)
			// 初始化顶点事件的最迟发生时间
			vl[i] = ve[G.getVexNum() - 1];
		while (!T.isEmpty()) {// 按拓扑逆序求各顶点的vl值
			int j = (Integer) T.pop();
			for (ArcNode arc = G.getVexs()[j].getFirstArc(); arc != null; arc = arc
					.getNextArc()) {
				int k = arc.getAdjVex();
				int value = arc.getValue();
				if (vl[k] - value < vl[j])
					vl[j] = vl[k] - value;
			}
		}

		for (int j = 0; j < G.getVexNum(); j++)
			// 求ee，el和关键活动
			for (ArcNode arc = G.getVexs()[j].getFirstArc(); arc != null; arc = arc
					.getNextArc()) {
				int k = arc.getAdjVex();
				int value = arc.getValue();
				int ee = ve[j];
				int el = vl[k] - value;
				char tag = (ee == el) ? '*' : ' ';
				System.out.println(G.getVex(j) + "->" + G.getVex(k) + " "
						+ value + " " + ee + " " + el + " " + tag);// 输出关键活动
			}
		return true;
	}

	public static void main(String[] args) throws Exception {
		ALGraph G = GenerateGraph.generateALGraph();
		CriticalPath p = new CriticalPath();
		p.criticalPath(G);

	}
}

// 调试结果
// v1->v4 5 0 3
// v1->v3 4 0 2
// v1->v2 6 0 0 *
// v2->v5 1 6 6 *
// v3->v5 1 4 6
// v4->v6 2 5 8
// v5->v8 7 7 7 *
// v5->v7 9 7 7 *
// v6->v8 4 7 10
// v7->v9 2 16 16 *
// v8->v9 4 14 14 *
