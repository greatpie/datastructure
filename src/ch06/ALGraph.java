package ch06;

import java.util.Scanner;

//图的邻接表存储表示
public class ALGraph implements IGraph {
	private GraphKind kind;// 图的种类标志

	private int vexNum, arcNum;// 图的当前顶点数和边数

	private VNode[] vexs;// 顶点

	public ALGraph() {
		this(null, 0, 0, null);
	}

	public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	// 创建图
	public void createGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入图的类型：");
		GraphKind kind = GraphKind.valueOf(sc.next());
		switch (kind) {
		case UDG:
			createUDG();// 构造无向图
			return;
		case DG:
			createDG();// 构造有向图
			return;
		case DN:
			createDN();// 构造有向网
			return;
		case UDN:
			createUDN();// 构造无向网
			return;
		}
	}

	// 创建无向图
	private void createUDG() {
		// 略
	};

	// 创建有向图
	private void createDG() {
		// 略
	};

	// 创建无向网
	private void createUDN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数:");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各各顶点:");
		for (int v = 0; v < vexNum; v++)
			// 构造顶点向量
			vexs[v] = new VNode(sc.next());

		System.out.println("请输入各各边的顶点及其权值:");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(sc.next());// 弧尾
			int u = locateVex(sc.next());// 弧头
			int value = sc.nextInt();
			addArc(v, u, value);
			addArc(u, v, value);
		}
	}

	// 创建有向网
	private void createDN() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数:");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各各顶点:");
		for (int v = 0; v < vexNum; v++)
			// 构造顶点向量
			vexs[v] = new VNode(sc.next());

		System.out.println("请输入各各边的顶点及其权值:");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(sc.next());// 弧尾
			int u = locateVex(sc.next());// 弧头
			int value = sc.nextInt();
			addArc(v, u, value);
		}
	}

	// 在位置为v、u的顶点之间，添加一条弧，其权值为value
	public void addArc(int v, int u, int value) {
		ArcNode arc = new ArcNode(u, value);
		arc.setNextArc(vexs[v].getFirstArc());
		vexs[v].setFirstArc(arc);
	}

	// 返回顶点数
	public int getVexNum() {
		return vexNum;
	}

	// 返边数
	public int getArcNum() {
		return arcNum;
	}

	// 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].getData().equals(vex))
				return v;
		return -1;
	}

	public VNode[] getVexs() {
		return vexs;
	}

	public GraphKind getKind() {
		return kind;
	}

	// 返回v表示结点的值， 0 <= v < vexNum
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		return vexs[v].getData();
	}

	// 返回v的第一个邻接点，若v没有邻接点则返回-1， 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");

		VNode vex = vexs[v];
		if (vex.getFirstArc() != null)
			return vex.getFirstArc().getAdjVex();
		else
			return -1;
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		VNode vex = vexs[v];

		ArcNode arcvw = null;
		for (ArcNode arc = vex.getFirstArc(); arc != null; arc = arc
				.getNextArc())
			if (arc.getAdjVex() == w) {
				arcvw = arc;
				break;
			}
		if (arcvw != null && arcvw.getNextArc() != null)
			return arcvw.getNextArc().getAdjVex();
		else
			return -1;
	}

}
