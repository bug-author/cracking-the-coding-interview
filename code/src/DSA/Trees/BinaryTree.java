package DSA.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {
	private static TreeNode root; // declared, NOT initialized (it would need data ~ see the constructor)
	// https://www.geeksforgeeks.org/nested-classes-java/
	// encapsulation

	public static void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);

		root = first;
		root.left = second;
		root.right = third;

		second.left = fourth;
		second.right = fifth;

		third.left = sixth;
		third.right = seventh;
	}

	static List<Integer> list = new ArrayList<>();

	public static void preOrderTraversalRecursive(TreeNode root) {
		/*
		 * visit root node visit left subtree visit right subtree
		 */
		if (root == null)
			return;

		list.add(root.getData());

		preOrderTraversalRecursive(root.left);
		preOrderTraversalRecursive(root.right);
	}

	public static void main(String[] args) {
		createBinaryTree();
		preOrderTraversalRecursive(root);
		System.out.println(list);
	}
}
