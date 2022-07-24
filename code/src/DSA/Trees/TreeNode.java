package DSA.Trees;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	private int data; // Generic type

	public TreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
}
