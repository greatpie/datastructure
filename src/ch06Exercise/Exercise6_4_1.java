package ch06Exercise;

import java.util.Scanner;

import ch06.ALGraph;
import ch06.GraphKind;
import ch06.VNode;

/**
 * 1.编写算法，从键盘读入有向图的顶点和弧，创建有向图的邻接表存储结构。
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_1 {

	public static ALGraph createDG() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入有向图的顶点数和边数:");
		int vexNum = sc.nextInt();
		int arcNum = sc.nextInt();
		VNode[] vexs = new VNode[vexNum];
		System.out.println("请分别输入有向图的各个顶点:");
		for (int v = 0; v < vexNum; v++)
			// 构造顶点向量
			vexs[v] = new VNode(sc.next());

		ALGraph G = new ALGraph(GraphKind.DG, vexNum, arcNum, vexs);

		System.out.println("请输入各个边的起点和终点:");
		for (int k = 0; k < arcNum; k++) {
			int v = G.locateVex(sc.next());
			int u = G.locateVex(sc.next());
			G.addArc(v, u, 0);
		}

		return G;
	}

	public static void main(String[] args) throws Exception {

		ALGraph G = Exercise6_4_1.createDG();

		System.out.println("构造的图为：");
		for (int i = 0; i < G.getVexNum(); i++) {
			System.out.print(G.getVex(i) + ": ");
			for (int w = G.firstAdjVex(i); w != -1; w = G.nextAdjVex(i, w)) {
				System.out.print(G.getVex(w) + "\t");
			}

			System.out.println();
		}
	}

}

// 调试结果：
// 请分别输入有向图的顶点数和边数:
// 3 2
// 请分别输入有向图的各个顶点:
// V0 V1 V2
// 请输入各个边的起点和终点:
// V0 V1
// V0 V2
// 构造的图为：
// V0: V2 V1
// V1:
// V2:
