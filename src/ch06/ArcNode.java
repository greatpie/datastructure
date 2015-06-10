package ch06;

//图的邻接表存储表示中的弧结点类
public class ArcNode {
	private int adjVex;// 该弧所指向的顶点位置

	private int value;// 边的权值

	private ArcNode nextArc;// 指向下一条弧

	public ArcNode() {
		this(-1, 0, null);
	}

	public ArcNode(int adjVex) {
		this(adjVex, 0, null);
	}

	public ArcNode(int adjVex, int value) {
		this(adjVex, value, null);
	}

	public ArcNode(int adjVex, int value, ArcNode nextArc) {
		this.value = value;
		this.adjVex = adjVex;
		this.nextArc = nextArc;
	}

	public int getValue() {
		return value;
	}

	public ArcNode getNextArc() {
		return nextArc;
	}

	public int getAdjVex() {
		return adjVex;
	}

	public void setAdjVex(int adjVex) {
		this.adjVex = adjVex;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNextArc(ArcNode nextArc) {
		this.nextArc = nextArc;
	}
}
