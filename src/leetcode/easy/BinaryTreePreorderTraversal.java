package leetcode.easy;

import leetcode.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        System.out.println(preorderTraversal(TreeNode.getTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal_Recursive(root, result);
        return result;
    }

    public static List<Integer> preorderTraversal_stack(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root != null)
            st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            result.add(node.val);
            if (node.right != null)
                st.push(node.right);
            if (node.left != null)
                st.push(node.left);
        }
        return result;
    }

    public static void preorderTraversal_Recursive(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorderTraversal_Recursive(node.left, list);
        preorderTraversal_Recursive(node.right, list);
    }
}
