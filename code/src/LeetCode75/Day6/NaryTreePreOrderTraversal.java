package LeetCode75.Day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class NaryTreePreOrderTraversal {
    // https://www.youtube.com/watch?v=DAIN1ZzvFeA&t=15s
    // static
    ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> preorder(Node root) {
        if (root == null) return ans;
        helperIterative(root);
        return ans;
    }

    public void helperRecursive(Node root){
        ans.add(root.val);

        // base condition
        if (root.children == null) return;


        for (Node child: root.children){
            helperRecursive(child);
        }
    }

    public void helperIterative(Node root){
        Stack<Node> stack = new Stack();

        stack.push(root);
        while (!stack.isEmpty()){
            Node curr = stack.pop();
            ans.add(curr.val);
            // reverse order
            for (int i = curr.children.size() - 1; i >= 0; i--){
                // push
                stack.push(curr.children.get(i));
            }
        }
    }
}
