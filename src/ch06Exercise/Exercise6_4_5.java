package ch06Exercise;

import ch06.GraphKind;
import ch06.MGraph;

/**
 * 5.编写克鲁斯卡尔算法构造最小生成树。
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_5 {
	public final static int INFINITY = Integer.MAX_VALUE;

	public static Object[][] KRUSKAL(MGraph G) throws Exception {
		Object[][] tree = new Object[G.getVexNum() - 1][2];// 存储最小生成树的边
		EqualClass A = new EqualClass(G);// 等价类数组
		MinHeap H = new MinHeap(G);// 用图G的边构造一个最小堆
		int count = 0;
		while (count < G.getVexNum() - 1) {// 用G.vexnum – 1条边构成最小生成树
			Object[] vexs = H.removeMin();// 取堆上最小边
			Object u = vexs[0];
			Object v = vexs[1];
			if (A.differ(u, v)) {// 如果u,v不在同一等价类中
				A.union(u, v);// 合并到同一等价类
				tree[count][0] = u;// 生成树的边放入数组中
				tree[count][1] = v;
				count++;
			}
		}

		return tree;
	}

	static class MinHeapNode {
		private Object[] vexs;// 边的两个顶点

		private int key;// 边的权值

		public MinHeapNode(Object[] vexs, int key) {
			this.vexs = vexs;
			this.key = key;
		}

		public Object[] getVexs() {
			return vexs;
		}

		public int getKey() {
			return key;
		}

	}

	static class MinHeap {

		private MinHeapNode[] heapArray;; // 堆容器

		private int maxSize; // 堆得最大大小

		private int currentSize; // 堆大小

		public MinHeap(MGraph G) throws Exception {
			maxSize = G.getVexNum() * G.getVexNum();
			heapArray = new MinHeapNode[maxSize];
			currentSize = 0;
			for (int i = 0; i < G.getVexNum(); i++) {
				for (int j = i + 1; j < G.getVexNum(); j++) {
					Object[] vexs = { G.getVex(i), G.getVex(j) };
					MinHeapNode newNode = new MinHeapNode(vexs,
							G.getArcs()[i][j]);
					insert(newNode);
				}
			}
		}

		// 自上而下调整
		public void filterDown(int start, int endOfHeap) {
			int i = start;
			int j = 2 * i + 1; // j是i的左子女位置
			MinHeapNode temp = heapArray[i];

			while (j <= endOfHeap) { // 检查是否到最后位置
				if (j < endOfHeap // 让j指向两子女中的小者
						&& heapArray[j].getKey() > heapArray[j + 1].getKey()) {
					j++;
				}
				if (temp.getKey() <= heapArray[j].getKey()) { // 小则不做调整
					break;
				} else { // 否则小者上移，i，j下降
					heapArray[i] = heapArray[j];
					i = j;
					j = 2 * j + 1;
				}
			}
			heapArray[i] = temp;
		}

		// 自下而上的调整:从结点start开始到0为止，自下向上比较，如果子女的值小于双亲结点的值则互相交换
		public void filterUp(int start) {
			int j = start;
			int i = (j - 1) / 2;
			MinHeapNode temp = heapArray[j];

			while (j > 0) { // 沿双亲结点路径向上直达根节点
				if (heapArray[i].getKey() <= temp.getKey()) {// 双亲结点值小，不调整
					break;
				} else {// 双亲结点值大，调整
					heapArray[j] = heapArray[i];
					j = i;
					i = (i - 1) / 2;
				}
				heapArray[j] = temp; // 回送
			}
		}

		// 堆中插入结点
		public void insert(MinHeapNode newNode) {
			heapArray[currentSize] = newNode;
			filterUp(currentSize);
			currentSize++;
		}

		// 删除堆中的最小值
		public Object[] removeMin() {
			MinHeapNode root = heapArray[0];
			heapArray[0] = heapArray[currentSize - 1];
			currentSize--;
			filterDown(0, currentSize - 1);
			return root.getVexs();
		}

	}

	static class EqualClass {
		private Object[] S;// 存放已经选择过的顶点

		private Object[] V;// 存放未选择的顶点

		EqualClass(MGraph G) {
			S = new Object[G.getVexNum()];
			V = new Object[G.getVexNum()];
			System.arraycopy(G.getVexs(), 0, V, 0, G.getVexs().length);
		}

		public boolean differ(Object u, Object v) {
			boolean isDiffer = false;
			int count = 0;
			for (int i = 0; i < V.length; i++) {
				if (V[i] != null && (V[i].equals(u) || V[i].equals(v)))
					++count;
			}

			if (count == 0 || count == 2)
				isDiffer = true;

			return isDiffer;
		}

		public void union(Object u, Object v) {
			boolean isHaveU = false;// u点是否已经被选择
			boolean isHaveV = false;
			int i = 0;
			for (; i < S.length && S[i] != null; i++) {
				if (S[i].equals(u))
					isHaveU = true;
				else if (S[i].equals(v))
					isHaveV = true;

			}

			if (!isHaveU)
				S[i] = u;

			if (!isHaveV)
				S[i] = v;

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
		Object[][] T = Exercise6_4_5.KRUSKAL(G);
		for (int i = 0; i < T.length; i++)
			System.out.println(T[i][0] + " - " + T[i][1]);
	}
}


//调试结果：
//v0 - v2
//v3 - v5
//v1 - v4
//v2 - v5
//v0 - v3