package ch06;

//图的接口
public interface IGraph {
	void createGraph();//创建一个图

	int getVexNum(); // 返回顶点数

	int getArcNum();// 返回边数

	Object getVex(int v) throws Exception;// 返回v表示结点的值， 0 <= v < vexNum

	int locateVex(Object vex);// 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1

	int firstAdjVex(int v) throws Exception; // 返回v的第一个邻接点，若v没有邻接点，则返回-1，其中0≤v<vexNum

	int nextAdjVex(int v, int w) throws Exception;// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum

}
