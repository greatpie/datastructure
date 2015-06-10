package ch06;

public class DebugMGraph {
	public static void main(String[] args) throws Exception {

		MGraph G = new MGraph();
		G.createGraph();

		for (int i = 0; i < G.getVexNum(); i++)
			System.out.print("\t" + G.getVexs()[i] + "\t");
		System.out.println();

		for (int i = 0; i < G.getVexNum(); i++) {
			System.out.print(G.getVex(i) + "\t");
			for (int j = 0; j < G.getVexNum(); j++)
				System.out.print(G.getArcs()[i][j] + "\t");

			System.out.println();
		}
	}
}
// 3 2
// V1 V2 V3
// V1 V2 3
// V1 V3 4
