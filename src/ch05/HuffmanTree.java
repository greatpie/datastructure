package ch05;

/**
 * 
 * 赫夫曼树及其操作
 * 
 */
public class HuffmanTree {

	// 求赫夫曼编码的算法，W存放n个字符的权值(均>0)
	public int[][] huffmanCoding(int[] W) {
		int n = W.length;// 字符个数
		int m = 2 * n - 1;// 赫夫曼树的结点数
		HuffmanNode[] HN = new HuffmanNode[m];
		int i;
		for (i = 0; i < n; i++)
			HN[i] = new HuffmanNode(W[i]);// 构造n个具有权值的结点

		for (i = n; i < m; i++) {// 建赫夫曼树
			// 在HN[0..i - 1]选择不在赫夫曼树中且weight最小的两个结点min1和min2
			HuffmanNode min1 = selectMin(HN, i - 1);
			min1.setFlag(1);
			HuffmanNode min2 = selectMin(HN, i - 1);
			min2.setFlag(1);

			// 构造min1和min2的父结点，并修改且父结点的权值
			HN[i] = new HuffmanNode();
			min1.setParent(HN[i]);
			min2.setParent(HN[i]);
			HN[i].setLchild(min1);
			HN[i].setRchild(min2);
			HN[i].setWeight(min1.getWeight() + min2.getWeight());
		}

		// 从叶子到根逆向求每个字符的赫夫曼编码
		int[][] HuffCode = new int[n][n];// 分配n个字符编码存储空间
		for (int j = 0; j < n; j++) {
			int start = n - 1;// 编码的开始位置，初始化为数组的结尾
			for (HuffmanNode c = HN[j], p = c.getParent(); p != null; c = p, p = p.getParent())
				// 从叶子到根逆向求编码
				if (p.getLchild().equals(c))// 左孩子编码为0
					HuffCode[j][start--] = 0;
				else
					// 右孩子编码为1
					HuffCode[j][start--] = 1;
			HuffCode[j][start] = -1;// 编码的开始标志为 -1，编码是-1之后的0、1序列
		}
		return HuffCode;
	}

	// 在HN[0..i - 1]选择不在赫夫曼树中且weight最小的结点
	private HuffmanNode selectMin(HuffmanNode[] HN, int end) {
		HuffmanNode min = HN[end];
		for (int i = 0; i <= end; i++) {
			HuffmanNode h = HN[i];
			if (h.getFlag() == 0 && h.getWeight() < min.getWeight())// 不在赫夫曼树中且weight最小的结点
				min = h;
		}
		return min;
	}

	public static void main(String[] args) {
		int[] W = { 23, 11, 5, 3, 29, 14, 7, 8 };// 初始化权值
		HuffmanTree T = new HuffmanTree();// 构造赫夫曼树
		int[][] HN = T.huffmanCoding(W);// 求赫夫曼编码

		System.out.println("赫夫曼编码为：");
		for (int i = 0; i < HN.length; i++) {// 输出赫夫曼编码
			System.out.print(W[i] + " ");
			for (int j = 0; j < HN[i].length; j++) {
				if (HN[i][j] == -1) {// 开始标志符读到数组结尾
					for (int k = j + 1; k < HN[i].length; k++)
						System.out.print(HN[i][k]);// 输出
					break;
				}
			}
			System.out.println();// 输出换行
		}
	}
}

// 运行结果：
// 赫夫曼编码为：
// 23 01
// 11 001
// 5 11111
// 3 11110
// 29 10
// 14 110
// 7 1110
// 8 000
