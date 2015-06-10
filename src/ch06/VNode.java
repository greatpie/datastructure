package ch06;

//图的邻接表存储表示中的顶点结点类
public class VNode {
	private Object data;// 顶点信息

	private ArcNode firstArc;// 指向第一条依附于该顶点的弧

	public VNode() {
		this(null, null);
	}
	public VNode(Object data) {
		this(data, null);
	}
	public VNode(Object data, ArcNode firstArc) {
		this.data = data;
		this.firstArc = firstArc;
	}

	public Object getData() {
		return data;
	}

	public ArcNode getFirstArc() {
		return firstArc;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setFirstArc(ArcNode firstArc) {
		this.firstArc = firstArc;
	}



}
