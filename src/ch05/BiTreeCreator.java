package ch05;

/**
 * 
 * 为了调试的需要，创建一棵树
 * 
 */
public class BiTreeCreator {

	// 初始化一棵树，并返回其根结点
	public BiTree createBiTree() {
		BiTreeNode A = new BiTreeNode('A');
		BiTreeNode B = new BiTreeNode('B');
		BiTreeNode C = new BiTreeNode('C');
		BiTreeNode D = new BiTreeNode('D');
		BiTreeNode E = new BiTreeNode('E');
		BiTreeNode F = new BiTreeNode('F', null, A);
		BiTreeNode G = new BiTreeNode('G', B, null);
		BiTreeNode H = new BiTreeNode('H', G, null);
		BiTreeNode I = new BiTreeNode('I', null, E);
		BiTreeNode J = new BiTreeNode('J', D, I);
		BiTreeNode K = new BiTreeNode('K', F, H);
		BiTreeNode L = new BiTreeNode('L', C, J);
		BiTreeNode root = new BiTreeNode('M', K, L);
		return new BiTree(root);
	}

	public BiTree createBiTree2() {
		BiTreeNode B = new BiTreeNode('B');
		BiTreeNode C = new BiTreeNode('C');
		BiTreeNode D = new BiTreeNode('D');
		BiTreeNode E = new BiTreeNode('E');
		BiTreeNode F = new BiTreeNode('F', null, null);
		BiTreeNode G = new BiTreeNode('G', B, null);
		BiTreeNode H = new BiTreeNode('H', G, null);
		BiTreeNode I = new BiTreeNode('I', null, E);
		BiTreeNode J = new BiTreeNode('J', D, I);
		BiTreeNode K = new BiTreeNode('K', F, H);
		BiTreeNode L = new BiTreeNode('L', C, J);
		BiTreeNode root = new BiTreeNode('M', K, L);
		return new BiTree(root);
	}
}
