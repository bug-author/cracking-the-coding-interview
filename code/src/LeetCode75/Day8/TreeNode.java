package LeetCode75.Day8;

public class TreeNode {
    int val;
    LeetCode75.Day8.TreeNode left;
    LeetCode75.Day8.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, LeetCode75.Day8.TreeNode left, LeetCode75.Day8.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
