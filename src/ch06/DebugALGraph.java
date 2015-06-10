package ch06;

public class DebugALGraph {
	public static void main(String[] args) throws Exception {

		ALGraph G = new ALGraph();
		G.createGraph();

		for (int i = 0; i < G.getVexNum(); i++) {
			System.out.print(G.getVex(i) + ": ");
			for(int w = G.firstAdjVex(i); w != -1; w = G.nextAdjVex(i, w)){
				System.out.print(G.getVex(w) + "\t");
			}

			System.out.println();
		}
	}
}
// 请输入图的类型：
// UDN
// 请分别输入图的顶点数、图的边数:
// 3 2
// 请分别输入图的各各顶点:
// V0 V1 V2
// 请输入各各边的顶点及其权值:
// V0 V1 3
// V0 V2 4
//输出结果：
// V0: V1 V2
// V1: V0
// V2: V0

// 请输入图的类型：
// DN
// 请分别输入图的顶点数、图的边数:
// 3 2
// 请分别输入图的各各顶点:
// V0 V1 V2
// 请输入各各边的顶点及其权值:
// V0 V1 3
// V0 V2 4
//输出结果：
// V0: V1 V2
// V1:
// V2:
