package LeetCode75.Day8;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helperRecursive(root, null, null);
    }

    public boolean helperRecursive(TreeNode root, Integer min, Integer max) {
        // RANGE
        /*
        The right/ left subtree of a node contains
        only nodes with keys greater/ smaller than the node's key
        */

        // if we have this far without getting false, it means tree is valid
        if (root == null) return true;

        // visualize left and right subtrees
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return helperRecursive(root.left, min, root.val) && helperRecursive(root.right, root.val, max);
    }
}
